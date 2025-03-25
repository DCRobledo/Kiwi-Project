package com.drobledo.kiwi;

import com.drobledo.kiwi.controller.SavedJobController;
import com.drobledo.kiwi.model.SavedJob;
import com.drobledo.kiwi.repository.SavedJobRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(SavedJobController.class)
public class SavedJobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SavedJobRepository savedJobRepository;

    @InjectMocks
    private SavedJobController savedJobController;

    private SavedJob savedJob;

    @BeforeEach
    public void setup() {
        savedJob = new SavedJob();
        savedJob.setTitle("Software Engineer");
        savedJob.setCompany("Kiwi Inc.");
    }

    @Test
    public void testCreateJob() throws Exception {
        // Mock the behavior of the repository's save method
        when(savedJobRepository.save(savedJob)).thenReturn(savedJob);

        // Perform POST request to create a job
        mockMvc.perform(post("/api/jobs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(savedJob)))
                .andExpect(status().isOk()); // Check for 200 OK status
    }
}
