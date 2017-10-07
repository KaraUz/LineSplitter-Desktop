package lt.karauz.line_splitter;

import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class AppTest
{
    public static class mainTest{
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        @Before
        public void setUpStream() {
            System.setOut(new PrintStream(outContent));
        }

        @Test
        public void IllegalParameterCount(){
            String expectedOutput =
                      "Illegal arguments: There must be exactly 2 arguments!" + System.getProperty("line.separator")
                    + "This program accepts input as follows:" + System.getProperty("line.separator")
                    + "number \"desired text\"" + System.getProperty("line.separator");
            App.main(new String[]{"a", "b", "c"});
            assertEquals(expectedOutput, outContent.toString());
        }

        @After
        public void cleanUpStream() {
            System.setOut(null);
        }
    }
}
