package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create mock
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Inject and test
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        // Step 4: Assert and verify
        assertEquals("Connected to Mock Connection", result);
        verify(mockNetworkClient).connect();
    }
}
