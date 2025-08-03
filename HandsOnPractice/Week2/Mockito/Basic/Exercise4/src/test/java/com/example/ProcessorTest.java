package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ProcessorTest {

    @Test
    void testVoidMethodLogCalled() {
        Logger mockLogger = mock(Logger.class);

        // Optional: stub the void method (not required unless you want to suppress behavior)
        doNothing().when(mockLogger).log(anyString());

        Processor processor = new Processor(mockLogger);
        processor.process();

        // Verify that the void method was called
        verify(mockLogger).log("Processing complete");
    }
}
