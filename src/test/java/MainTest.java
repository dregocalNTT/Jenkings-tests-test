
import com.example.Main;

import org.junit.jupiter.api.*;


public class MainTest {

    @Test
    public void testSumarNumeros() {
        int result = Main.sumarNumeros(5, 7);
        Assertions.assertEquals(12, result);
    }

    @Test
    public void testRestarNumeros() {
        int result = Main.restarNumeros(4, 2);
        Assertions.assertEquals(2, result);
    }
}   