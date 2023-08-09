import java.io.IOException;
import java.util.Scanner;


public class encryption {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        String passkey="", encrypted = "", decrypted = "";

        while(true) {
            // read in command from driver
            String input = scan.nextLine();
            String[] string = input.split("\\s+", 2);
            String command = string[0];
            String response = string[1];

            if (command.equalsIgnoreCase("PASSKEY")) {
                passkey = response;
                System.out.println("RESULT \nEnter a command: ");
                input = scan.nextLine();
                string = input.split("\\s+", 2);
                command = string[0];
                response = string[1];
            }

            if (command.equalsIgnoreCase("ENCRYPT")) {
                if (passkey.equals("")) {
                    System.out.println("ERROR passkey not set ");
                }
                System.out.println("Enter passkey: ");
                passkey = scan.nextLine();
                System.out.println("Enter a command: ");
                input = scan.nextLine();
                input.split("\\s+", 2);
                command = string[0];
                response = string[1];

                if (command.equalsIgnoreCase("ENCRYPT")) {
                    String key = "abc";
                    for (int i = 0; i < response.length(); i++) {
                        key = (key.charAt(i) + key);
                    }
                    for (int i = 0; i < response.length(); i++) {
                        int value = (key.charAt(i) + response.charAt(i)) % 26;
                        value = value + 'A';
                        encrypted = encrypted + (char)(value);

                    }
                    System.out.println("Please enter passkey: ");
                    System.out.println("RESULT "+encrypted);
                }
           // }
            } else if (command.equalsIgnoreCase("DECRYPT")) {
                System.out.println("Would you like to use a string from history? Please enter yes or no.");
                if (scan.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println("print history");
                } else {
                    System.out.println("What is the new string?");
                    String newString = scan.nextLine();

                    // logic for decrypt but no chance to set it up within the if else statements
                    /*for(int i=0; i<encrypted.length(); i++) {
                        int value = (key.charAt(i) + string.charAt(i)+26) % 26;
                        value = value + 'A';
                        decrypted = decrypted + (char)(value);*/
                }

            } else if (command.equalsIgnoreCase("QUIT")) {
                System.out.println("PROGRAM TERMINATED"); // send quit to driver
                break;
            }
        } // while
    } // main
} // class
