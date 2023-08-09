import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.lang.String;


public class logger {

    public static void main(String args[]) throws IOException {
       Scanner scan = new Scanner(System.in);
       String name = scan.nextLine();
       File file = new File(name);
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
       Date currentDate = new Date();
       String formattedDate = dateFormat.format(currentDate);
       FileWriter fw = new FileWriter(name, true);
       BufferedWriter bw = new BufferedWriter(fw);
       bw.write(formattedDate.toString() + " [START] Logging Started.\n");


       String input = scan.nextLine();
       if(input.equalsIgnoreCase("QUIT")) {
           bw.write(formattedDate.toString() + " [STOP] Logging Stopped.\n");
       }



        // close file
        bw.close();
    } // main
} // end of logger


