package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.eq;

public class AlertManagerTest {

    @Test
    void testSendCalledWithCorrectArguments() {
        NotificationService mockNotificationService = mock(NotificationService.class);
        AlertManager alertManager = new AlertManager(mockNotificationService);
        alertManager.alert("admin@example.com");

        System.out.println(">>> Test is running");

        verify(mockNotificationService).send(
                eq("admin@example.com"),
                eq("This is a critical alert!")
        );
    }
}
