package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Create mocks
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Stub read method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Inject mocks
        FileService fileService = new FileService(mockFileReader, mockFileWriter);

        // Execute method
        String result = fileService.processFile();

        // Verify result
        assertEquals("Processed Mock File Content", result);

        // Verify interaction
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
