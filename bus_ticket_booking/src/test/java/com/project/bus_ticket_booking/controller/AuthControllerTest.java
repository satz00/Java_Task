package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.UserRepository;
import com.project.bus_ticket_booking.service.BusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private BusService busService;

    @Mock
    private Model model;

    @Mock
    private RedirectAttributes redirectAttributes;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("encodedPassword");
        user.setRole("ROLE_USER");
    }

    @Test
    void registerUser_Success() {
        when(userRepository.findByUsername("testuser")).thenReturn(null);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        User newUser = new User();
        newUser.setUsername("testuser");
        newUser.setPassword("password");

        String result = authController.registerUser(newUser, redirectAttributes);

        verify(userRepository, times(1)).save(any(User.class));
        assertEquals("redirect:/login", result);
    }

    @Test
    void registerUser_Fail_DuplicateUsername() {
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        String result = authController.registerUser(user, redirectAttributes);

        verify(userRepository, never()).save(any(User.class));
        assertEquals("redirect:/register", result);
    }

    @Test
    void dashboardPage_Success() {
        UserDetails mockUserDetails = mock(UserDetails.class);
        when(mockUserDetails.getUsername()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        String result = authController.dashboardPage(mockUserDetails, model);

        verify(model, times(1)).addAttribute("username", "testuser");
        verify(model, times(1)).addAttribute("userId", 1L);
        assertEquals("dashboard", result);
    }

    @Test
    void updateProfilePage_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        String result = authController.updateProfilePage(1L, model);

        verify(model, times(1)).addAttribute("user", user);
        assertEquals("profile", result);
    }

    @Test
    void updateProfilePage_Fail_UserNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            authController.updateProfilePage(2L, model);
        });

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void updateProfile_ChangeEmailOnly() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        String result = authController.updateProfile(1L, "newemail@example.com", null, null, redirectAttributes);

        verify(userRepository, times(1)).save(user);
        assertEquals("newemail@example.com", user.getEmail());
        assertEquals("redirect:/profile/1", result);
    }

    @Test
    void updateProfile_ChangePassword_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("oldpassword", "encodedPassword")).thenReturn(true);
        when(passwordEncoder.encode("newpassword")).thenReturn("encodedNewPassword");

        String result = authController.updateProfile(1L, "testuser@example.com", "oldpassword", "newpassword", redirectAttributes);

        verify(userRepository, times(1)).save(user);
        assertEquals("encodedNewPassword", user.getPassword());
        assertEquals("redirect:/profile/1", result);
    }

    @Test
    void updateProfile_ChangePassword_Fail_WrongOldPassword() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrongpassword", "encodedPassword")).thenReturn(false);

        String result = authController.updateProfile(1L, "testuser@example.com", "wrongpassword", "newpassword", redirectAttributes);

        verify(userRepository, never()).save(user);
        assertEquals("redirect:/profile/1", result);
    }
}
