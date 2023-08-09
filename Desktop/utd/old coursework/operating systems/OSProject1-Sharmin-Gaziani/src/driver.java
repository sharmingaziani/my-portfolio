import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class driver {
    public static void main(String[] args) throws IOException, InterruptedException {

        while (true) {

            Scanner scan = new Scanner(System.in);

            // create process
            Process logProcess = Runtime.getRuntime().exec("java logger");
            // System.out.println(logProcess.isAlive());
            InputStream inStreamL = logProcess.getInputStream();
            OutputStream outStreamL = logProcess.getOutputStream();
            Scanner fromLog = new Scanner(inStreamL);
            PrintStream toLog = new PrintStream(outStreamL);

            Process encryptProcess = Runtime.getRuntime().exec("java encryption");
            InputStream inStreamE = encryptProcess.getInputStream();
            OutputStream outStreamE = encryptProcess.getOutputStream();
            Scanner fromEncrypt = new Scanner(inStreamE);
            PrintStream toEncrypt = new PrintStream(outStreamE);

            // file name from user
            System.out.println("Enter file name: ");
            String fileName = scan.nextLine();
            // send filename to logger
            toLog.println(fileName);
            toLog.flush();

            //formatting for menu output
            for (int i = 0; i < 30; i++)
                System.out.print("- ");
            System.out.println("");
            for (int i = 0; i < 25; i++)
                System.out.print(" ");
            System.out.println("MENU");
            for (int i = 0; i < 30; i++)
                System.out.print("- ");
            System.out.print("\nPASSKEY: Sets current passkey to use when encrypting/decrypting");
            System.out.print("\nENCRYPT: Encrypt a string using current passkey");
            System.out.print("\nDECRYPT: Decrypt a string using current passkey");
            System.out.print("\nQUIT: Exit the program");
            System.out.print("\nHISTORY: Show history\n");
            for (int i = 0; i < 30; i++)
                System.out.print("- ");
            // enter new command
            System.out.println("\nEnter command: ");
            String input = scan.nextLine();
            // send command to encrypt
            toEncrypt.println(input);
            toEncrypt.flush();

            while (fromEncrypt.hasNextLine() && input != "QUIT" || input != "quit") {
                System.out.println(fromEncrypt.nextLine());
                input = scan.nextLine();
                toLog.println("QUIT");
                toEncrypt.println(input);
                toEncrypt.flush();
                toLog.flush();
            }


            // close pipes
            toLog.close();
            toEncrypt.close();
            fromLog.close();
            fromEncrypt.close();
        } // while
    }
}
