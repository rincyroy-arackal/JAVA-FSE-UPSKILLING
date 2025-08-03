import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setup...");
        calculator = new Calculator(); // Arrange
    }

    @After
    public void tearDown() {
        System.out.println("Cleanup...");
        calculator = null;
    }

    @Test
    public void testAddition() {
        int result = calculator.add(2, 3); // Act
        assertEquals(5, result);           // Assert
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 4); // Act
        assertEquals(6, result);                // Assert
    }
}
