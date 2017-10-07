package lt.karauz.line_splitter.Utilities;

public class StringUtilities {
    private StringUtilities() { }

    public static String splitIntoLines(String text, int lettersPerLine)throws IllegalArgumentException{
        StringBuilder builder = new StringBuilder();
        builder.append(text);
        return builder.toString();
    }
}
