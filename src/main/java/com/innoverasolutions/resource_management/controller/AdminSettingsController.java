package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.model.TestResult;
import com.innoverasolutions.resource_management.service.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminSettingsController {

    @Autowired
    private TestResultService testResultService;  // Service to fetch test results from DB

    // Get method to display the settings page
    @GetMapping("/settings")
    public String settingsPage() {
        // Return the settings page template
        return "settings"; // Make sure this matches your settings.html Thymeleaf template name
    }

    // Post method to update settings
    @PostMapping("/settings/update")
    public String updateSettings(@RequestParam("companyName") String companyName,
                                 @RequestParam("emailNotifications") String emailNotifications,
                                 @RequestParam("passwordPolicy") String passwordPolicy,
                                 RedirectAttributes redirectAttributes) {
        // Here you can implement the logic to save these settings (e.g., to a database or properties file)
        System.out.println("Company Name: " + companyName);
        System.out.println("Email Notifications: " + emailNotifications);
        System.out.println("Password Policy: " + passwordPolicy);

        // Add a success message to the redirect
        redirectAttributes.addFlashAttribute("successMessage", "Settings updated successfully!");

        // Redirect back to the settings page
        return "redirect:/admin/settings";
    }

    // Get method to display the hackathon results page
    @GetMapping("/hackathon-results")
    public String viewHackathonResults(Model model) {
        // Fetch all test results from the service
        List<TestResult> results = testResultService.getAllTestResults();

        // Add the results to the model
        model.addAttribute("results", results);

        // Return the hackathon results page template
        return "hackathon-results"; // Ensure this matches your hackathon-results.html Thymeleaf template
    }

}
