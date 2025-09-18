
import com.example.Main;
import org.junit.jupiter.*;
import org.junit.jupiter.api.*;


public class MainTest {

    @Test
    public void testAddNumbers() {
        int result = Main.sumarNumeros(5, 7);
        Assertions.assertEquals(12, result);
    }
}   