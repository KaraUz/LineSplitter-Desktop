package lt.karauz.line_splitter;

import lt.karauz.line_splitter.Utilities.StringUtilities;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            if(args.length != 2)
                throw new IllegalArgumentException("There must be exactly 2 arguments!");

            int lineLength = Integer.parseInt(args[0]);
            String text = args[1];

            System.out.println(StringUtilities.splitIntoLines(text, lineLength));
        } catch (NumberFormatException e) {
            displayDesiredInput();
        } catch (IllegalArgumentException e){
            System.out.println("Illegal arguments: " + e.getMessage());
            displayDesiredInput();
        }
    }

    private static void displayDesiredInput(){
        System.out.println("This program accepts input as follows:");
        System.out.println("number \"desired text\"");
    }
}
