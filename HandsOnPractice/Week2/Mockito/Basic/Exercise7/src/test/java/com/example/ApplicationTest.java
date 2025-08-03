package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {

    @Test
    public void testLoggerThrowsException() {
        Logger mockLogger = mock(Logger.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Logging failed")).when(mockLogger).log("App is running...");

        Application app = new Application(mockLogger);

        RuntimeException thrown = assertThrows(RuntimeException.class, app::run);
        assertEquals("Logging failed", thrown.getMessage());

        // Verify interaction still happened
        verify(mockLogger).log("App is running...");
    }
}
