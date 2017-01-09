import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Boronin on 1/9/2017.
 */
public class IOMaster {
    public static Timer timer;
    public static File file;
    public static FileReader fr;
    public static FileWriter fw;
    public static Scanner scanner;

    public void printHeader() {
        System.out.println("Area: Android development");
        System.out.println("- Java");
        System.out.println("- Android SDK");
        System.out.println("- Data base");
        System.out.println("- Git");
        System.out.println("- Soft skills");
        System.out.println("");
        System.out.println("Hey, bro! How much time you spent today that be the Professional?");
        System.out.println("");
        System.out.println("Enter a numbers of hours:");
    }

    public void todayReader() throws IOException {
        fr = new FileReader(file);
        scanner = new Scanner(fr);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        // Reading today data
        timer.todayHours = new Float(0.0);
        try {
            timer.todayHours = Float.parseFloat(consoleInput.readLine());
        }
        catch (NumberFormatException nfe) {
            System.out.println("You didn't enter value");
        }
        timer.totalHours = timer.todayHours + timer.completeHours;
        fr.close();
        //
    }

    public void oldReader() {
        // Reading old data
        timer.completeHours = scanner.nextFloat();
        //
    }

    public void totalWriter() throws IOException{
        // Writing total data
        try {
            fw = new FileWriter(file, false);
            fw.write(timer.totalHours.toString());
        }
        catch (IOException ioe) {
            System.out.println("File have troubles in writing");
        }
        finally {
            fw.close();
        }
    }
}
