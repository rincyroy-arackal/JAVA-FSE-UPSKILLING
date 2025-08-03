package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        // Step 1: Mock the repository
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub the getData() method to return different values
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // Step 3: Create service with mock repository
        Service service = new Service(mockRepository);

        // Step 4: Call method twice and assert different results
        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);

        // Optional: Verify it was called twice
        verify(mockRepository, times(2)).getData();
    }
}
