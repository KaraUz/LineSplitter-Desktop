package lt.karauz.line_splitter.Utilities;

import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class StringUtilitiesTest {

    public static class SplitIntoLinesTest {
        @Rule
        public final ExpectedException expectedException = ExpectedException.none();

        @Test
        public void ThreeLinesAsExpected() {
            String text = "Our goal is to keep an innovation first attitude at the center of TeleSoftas. We encourage our employees to search, build, and innovate -- and that’s what really makes things happen.";
            String textExpected =
                    "Our goal is to keep an innovation first attitude at the center of\n"
                            + "TeleSoftas. We encourage our employees to search, build, and\n"
                            + "innovate -- and that’s what really makes things happen.";

            String formattedText = StringUtilities.splitIntoLines(text, 68);

            assertEquals(formattedText, textExpected);
        }

        @Test
        public void NullText() {
            expectedException.expect(IllegalArgumentException.class);
            StringUtilities.splitIntoLines(null, 70);
        }

        @Test
        public void LineLengthLessThanOne() {
            String text = "Our goal is to keep an innovation first attitude at the center of TeleSoftas. We encourage our employees to search, build, and innovate -- and that’s what really makes things happen.";

            expectedException.expect(IllegalArgumentException.class);
            StringUtilities.splitIntoLines(text, 0);
        }

        @Test
        public void WordLongerThanLine() {
            String text = "Incomprehensibilities";
            String textExpected = "Incomprehe\nnsibilitie\ns";

            String formattedText = StringUtilities.splitIntoLines(text,10);

            assertEquals(formattedText, textExpected);
        }

        @Test
        public void WordEqualToLine() {
            String text = "Incomprehensibilities";
            String textExpected = "Incomprehensibilities";

            String formattedText = StringUtilities.splitIntoLines(text,21);

            assertEquals(formattedText, textExpected);
        }

        @Test
        public void LineLongerThanWord() {
                String text = "Incomprehensibilities";
                String textExpected = "Incomprehensibilities";

                String formattedText = StringUtilities.splitIntoLines(text,68);

                assertEquals(formattedText, textExpected);
        }
    }
}