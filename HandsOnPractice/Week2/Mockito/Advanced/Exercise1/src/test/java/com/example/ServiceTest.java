package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Step 1: Create mock
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Step 3: Inject into service
        Service service = new Service(mockRepository);

        // Step 4: Test service logic
        String result = service.processData();

        // Step 5: Assert the result
        assertEquals("Processed Mock Data", result);

        // Step 6: Verify interaction
        verify(mockRepository).getData();
    }
}
