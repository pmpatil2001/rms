package com.innoverasolutions.resource_management.service;

import com.innoverasolutions.resource_management.model.TestResult;
import com.innoverasolutions.resource_management.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultService {

    @Autowired
    private TestResultRepository testResultRepository;

    // Method to fetch all test results
    public List<TestResult> getAllResults() {
        return testResultRepository.findAll();  // Fetches all records from the database
    }

    // Method to save a test result
    public void saveResult(TestResult result) {
        testResultRepository.save(result);  // Saves the result to the database
    }

    // Implement the getAllTestResults method
    public List<TestResult> getAllTestResults() {
        return testResultRepository.findAll();  // Fetches all records from the database (same as getAllResults)
    }
}
