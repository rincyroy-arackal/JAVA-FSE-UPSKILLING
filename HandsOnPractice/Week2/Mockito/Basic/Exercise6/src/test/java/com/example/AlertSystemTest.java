package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class AlertSystemTest {

    @Test
    public void testInteractionOrder() {
        Notifier mockNotifier = mock(Notifier.class);
        AlertSystem alertSystem = new AlertSystem(mockNotifier);

        alertSystem.triggerAlert();

        InOrder inOrder = inOrder(mockNotifier);

        inOrder.verify(mockNotifier).connect();
        inOrder.verify(mockNotifier).sendAlert("Intrusion detected!");
        inOrder.verify(mockNotifier).disconnect();
    }
}
