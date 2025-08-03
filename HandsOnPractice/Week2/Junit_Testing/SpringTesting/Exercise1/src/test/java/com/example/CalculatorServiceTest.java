package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();

        int result = calculatorService.add(5, 3);

        assertEquals(8, result, "Addition of 5 and 3 should be 8");
    }
}
