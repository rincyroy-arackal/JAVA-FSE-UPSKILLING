package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Create mock RestClient
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub the method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Inject mock into ApiService
        ApiService apiService = new ApiService(mockRestClient);

        // Step 4: Execute and verify
        String result = apiService.fetchData();
        assertEquals("Fetched Mock Response", result);

        // Optional: Verify interaction
        verify(mockRestClient).getResponse();
    }
}
