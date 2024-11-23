package com.innoverasolutions.resource_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;  // Store the username (optional)
    private String q1Answer;
    private String q2Answer;
    private String q3Answer;
    private int score; // Store the score for the test

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQ1Answer() {
        return q1Answer;
    }

    public void setQ1Answer(String q1Answer) {
        this.q1Answer = q1Answer;
    }

    public String getQ2Answer() {
        return q2Answer;
    }

    public void setQ2Answer(String q2Answer) {
        this.q2Answer = q2Answer;
    }

    public String getQ3Answer() {
        return q3Answer;
    }

    public void setQ3Answer(String q3Answer) {
        this.q3Answer = q3Answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
