package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiServiceTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stubbing with multiple returns
        when(mockApi.getStatus())
                .thenReturn("OK")
                .thenReturn("FAILED");

        MultiService service = new MultiService(mockApi);
        String result = service.checkTwice();

        assertEquals("OK then FAILED", result);
    }
}
