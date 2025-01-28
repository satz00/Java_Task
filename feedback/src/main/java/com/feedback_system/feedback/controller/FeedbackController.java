package com.feedback_system.feedback.controller;

import com.feedback_system.feedback.entity.Feedback;
import org.springframework.ui.Model;
import com.feedback_system.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/")
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback-form";
    }

    @PostMapping("/submitFeedback")
    public String saveFeedback(@RequestParam String name, @RequestParam String bookName, @RequestParam String feedback, Model model) {
        Feedback newFeedback = new Feedback();
        newFeedback.setName(name);
        newFeedback.setBookName(bookName);
        newFeedback.setFeedback(feedback);

        feedbackService.saveFeedback(newFeedback);

        model.addAttribute("message", "Feedback saved!");
        return "feedback-form";
    }

}
