package lt.karauz.line_splitter.Utilities;


import org.omg.CORBA.Environment;

public class StringUtilities {
    public final static String LINE_SEPARATOR = "\n";//use System.getProperty("line.separator") for system separator

    private StringUtilities() { }

    public static String splitIntoLines(String text, int lettersPerLine)throws IllegalArgumentException{
        if(text == null)
            throw new IllegalArgumentException("Text must be a non null String!");

        if(lettersPerLine < 1)
            throw new IllegalArgumentException("Letters per line must be greater than 0!");

        StringBuilder builder = new StringBuilder();

        int startIndex = 0;
        int endIndex = text.length() > startIndex + lettersPerLine ? startIndex + lettersPerLine : text.length();
        String substring = text.substring(startIndex, endIndex);

        while (substring.length() > 0) {
            if(startIndex > 0) builder.append(LINE_SEPARATOR);

            int indexOfCut = substring.lastIndexOf(' ');

            if (indexOfCut < 0 || endIndex == text.length()) {
                //There is no space in the substring, must cut the word
                builder.append(substring);
                startIndex += substring.length();
            } else {
                builder.append(substring.substring(0, indexOfCut));
                startIndex += indexOfCut + 1;
            }

            endIndex = text.length() > startIndex + lettersPerLine ? startIndex + lettersPerLine : text.length();
            substring = text.substring(startIndex, endIndex);
        }

        return builder.toString();
    }
}
