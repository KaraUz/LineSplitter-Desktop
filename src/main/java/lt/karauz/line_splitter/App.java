package lt.karauz.line_splitter;

import lt.karauz.line_splitter.Utilities.StringUtilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        if(args.length > 0) {
            HandleDirectInput(args);
        }else{
            HandleConversationInput();
        }
    }

    private static void HandleDirectInput(String[] args){
        try {
            if (args.length != 2)
                throw new IllegalArgumentException("There must be exactly 2 arguments!");

            int lineLength = Integer.parseInt(args[0]);
            String text = args[1];

            System.out.println(StringUtilities.splitIntoLines(text, lineLength));
        } catch (NumberFormatException e) {
            displayDesiredInput();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments: " + e.getMessage());
            displayDesiredInput();
        }
    }

    private static void HandleConversationInput(){
        try {
            boolean willContinue = true;
            Scanner scanner = new Scanner(System.in);
            while (willContinue) {
                System.out.println("Please enter the text you want to split into lines:");
                String text = scanner.nextLine();

                System.out.print("How many letters per line?: ");
                int lineLength = scanner.nextInt();

                System.out.println("Your text: ");
                System.out.println(StringUtilities.splitIntoLines(text, lineLength));

                while (true){
                    System.out.print("Continue? Y/N: ");

                    char continueChar = scanner.next().charAt(0);
                    scanner.nextLine();

                    if (Character.toLowerCase(continueChar) == 'y') {
                        willContinue = true;
                        System.out.println();
                        break;
                    } else if (Character.toLowerCase(continueChar) == 'n') {
                        willContinue = false;
                        break;
                    }
                }

            }
        } catch (NumberFormatException|InputMismatchException e) {
            displayDesiredInput();
            HandleConversationInput();
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments: " + e.getMessage());
            displayDesiredInput();
            HandleConversationInput();
        }
    }

    private static void displayDesiredInput(){
        System.out.println("This program accepts input as follows:");
        System.out.println("number \"desired text\"");
    }
}
