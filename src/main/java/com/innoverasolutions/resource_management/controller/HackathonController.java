package com.innoverasolutions.resource_management.controller;

import com.innoverasolutions.resource_management.model.Hackathon;
import com.innoverasolutions.resource_management.model.TestResult;
import com.innoverasolutions.resource_management.service.TestResultService;
import com.innoverasolutions.resource_management.service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HackathonController {

    @Autowired
    private HackathonService hackathonService;

    @Autowired
    private TestResultService testResultService;

    // Display list of hackathons
    @GetMapping("/hackathons")
    public String hackathons(Model model) {
        model.addAttribute("hackathons", hackathonService.findHackathons());
        return "hackathons";
    }

    // Register a new hackathon
    @GetMapping("/registerHackathon")
    public String registerHackathon(Model model) {
        model.addAttribute("hackathon", new Hackathon());
        return "registerHackathon";
    }

    @PostMapping("/saveHackathon")
    public String saveHackathon(@ModelAttribute("hackathon") Hackathon hackathon) {
        hackathonService.saveHackathon(hackathon);
        return "redirect:/hackathons";
    }

    // Update an existing hackathon
    @GetMapping("/updateHackathon/{id}")
    public String updateHackathon(@PathVariable Long id, Model model) {
        model.addAttribute("hackathon", hackathonService.getHackathonId(id));
        return "updateFormHackathon";
    }

    // Delete a hackathon
    @GetMapping("/deleteHackathon/{id}")
    public String deleteHackathon(@PathVariable Long id) {
        hackathonService.deleteHackathon(id);
        return "redirect:/hackathons";
    }

    // Display the MCQ test page
    @GetMapping("/mcq")
    public String showMCQPage() {
        return "mcq"; // Corresponds to mcq.html
    }

    // Handle MCQ test submission and save result to the database
    @PostMapping("/submit-mcq")
    public String submitTest(@RequestParam("q1") String q1,
                             @RequestParam("q2") String q2,
                             @RequestParam("q3") String q3,
                             @RequestParam(value = "username", required = false) String username, // Optional username
                             Model model) {
        int score = 0;

        // Check answers and calculate score
        if (q1.equals("4")) score++;
        if (q2.equals("Use of pointers")) score++;
        if (q3.equals("false")) score++;

        int totalQuestions = 3;

        // Create TestResult object to save to the database
        TestResult testResult = new TestResult();
        testResult.setQ1Answer(q1);
        testResult.setQ2Answer(q2);
        testResult.setQ3Answer(q3);
        testResult.setScore(score);

        // If username is provided, set it in the TestResult
        if (username != null && !username.isEmpty()) {
            testResult.setUsername(username);
        }

        // Save the test result to the database
        testResultService.saveResult(testResult);

        // Add score and totalQuestions to model to be passed to result.html
        model.addAttribute("score", score);
        model.addAttribute("totalQuestions", totalQuestions);

        return "result";  // This will render result.html
    }
}
