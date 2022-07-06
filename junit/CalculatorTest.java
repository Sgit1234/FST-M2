package examples;
import org.junit.Assert;
import org.junit.jupiter.api.*;

    public class CalculatorTest {

        static Calculator calc;

        @BeforeAll
        static void setUp() throws Exception {
            calc = new Calculator();
        }

        @Test
        @DisplayName("Simple addition should work")
        public void additionTest(){
            int result=calc.add(8,10);
            System.out.println ("The sum is "  + result);
            Assert.assertEquals(18, result);
        }
        @Test
        @DisplayName("Simple multiplication should work")
        public void testMultiply() {
            int result=calc.multiply(8,10);
            System.out.println ("The product is "  + result);
            Assert.assertEquals(80, result);

        }
    }

