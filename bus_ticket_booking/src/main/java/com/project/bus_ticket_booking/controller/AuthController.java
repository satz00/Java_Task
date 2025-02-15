package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.UserRepository;
import com.project.bus_ticket_booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BusService busService;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("Login page");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(@RequestParam(value = "error", required = false) String error, Model model) {
        System.out.println("Register page");
        model.addAttribute("User", new User());
        model.addAttribute("error", error);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (existingUser.isPresent()){
            redirectAttributes.addAttribute("error", "Username already taken");
            return "redirect:/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(@AuthenticationPrincipal org.springframework.security.core.userdetails.UserDetails userDetails, Model model) {
        String userName = userDetails.getUsername();
        User user = userRepository.findByUsername(userName);
        System.out.println("userId :"+ user.getId());
        System.out.println("Dashboard");
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userId", user.getId());
        model.addAttribute("Buses", null);
        return "dashboard";
    }

    @GetMapping("/profile/{userId}")
    public String updateProfilePage(@PathVariable Long userId, Model model) {
        System.out.println("Entered the profile");
        System.out.println(userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("user", user);
        return "profile";
    }


    @PostMapping("/update-profile")
    public String updateProfile(
            @RequestParam Long userId,
            @RequestParam String email,
            @RequestParam(required = false) String oldPassword,
            @RequestParam(required = false) String newPassword,
            RedirectAttributes redirectAttributes) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmail(email);

        if (newPassword != null && !newPassword.isEmpty()) {
            if (oldPassword == null || !passwordEncoder.matches(oldPassword, user.getPassword())) {
                redirectAttributes.addFlashAttribute("error", "Old password is incorrect!");
                return "redirect:/profile/" + userId;
            }
            user.setPassword(passwordEncoder.encode(newPassword));
        }

        userRepository.save(user);

        redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
        return "redirect:/profile/"+ userId;
    }

}
