package com.drobledo.kiwi;

import com.drobledo.kiwi.model.SavedJob;
import com.drobledo.kiwi.repository.SavedJobRepository;
import com.drobledo.kiwi.service.SavedJobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SavedJobServiceTest {

    @Mock
    private SavedJobRepository savedJobRepository;

    @InjectMocks
    private SavedJobService savedJobService;

    private SavedJob savedJob;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        savedJob = new SavedJob();
        savedJob.setTitle("Software Engineer");
        savedJob.setCompany("Kiwi Inc.");
    }

    @Test
    public void testAddJob() {
        // Mock the repository to return the saved job
        when(savedJobRepository.save(savedJob)).thenReturn(savedJob);

        // Call the service method
        SavedJob result = savedJobService.addJob(savedJob);

        // Verify interactions and assert results
        assertNotNull(result);
        assertEquals(savedJob.getTitle(), result.getTitle());
        verify(savedJobRepository, times(1)).save(savedJob);
    }
}
