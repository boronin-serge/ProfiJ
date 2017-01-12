import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.NoSuchElementException;
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
    public static BufferedReader consoleInput;

    public IOMaster() throws IOException {
        timer = new Timer();
        file = new File("data.txt");     // bind file and object of File
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void printHeader() {
        System.out.println("Area: Android development");
        System.out.println("- Java");
        System.out.println("- Android SDK");
        System.out.println("- Data base");
        System.out.println("- Git");
        System.out.println("- Soft skills");
        System.out.println("- English language");
        System.out.println("");
        System.out.println("Hey, bro! How much time you spent today that be the Professional?");
        System.out.println("");
    }

    public void printBody() throws IOException{
        System.out.println("You worked " + timer.totalHours + " hours");
        System.out.println("In order to become a Pro left " + (10000 - timer.totalHours) + " hours");
    }

    public void todayReader() throws IOException {

        // Reading today data
        try {
            System.out.println("Enter a numbers of hours:");
            timer.todayHours = new Float(0.0);
            fr = new FileReader(file);
            scanner = new Scanner(fr);
            consoleInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    timer.todayHours = Float.parseFloat(consoleInput.readLine());
                    if (timer.todayHours >= 0.0f && timer.todayHours <= 24f) {
                        break;
                    }
                    else if (timer.todayHours > 24f) {
                        System.out.println("You can't work more 24 hours per day");
                    }
                    else {
                        System.out.println("Value can't be negative");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("You didn't enter a value");
                }
                catch (NullPointerException e) {
                    System.out.println("Error. You entered: " + timer.todayHours);
                }
            }
            timer.totalHours = timer.todayHours + timer.completeHours;
        }
        catch (IOException e) {
            System.out.println("IOException in todayReader");
        }
        finally {
            fr.close();
            scanner.close();
        }
            //
    }

    public void oldReader() throws IOException {
        // Reading old data
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file,true);
            scanner = new Scanner(fr);
            timer.completeHours = scanner.nextFloat();
        }
        catch (NoSuchElementException e) {
            try {
                timer.completeHours = 0f;
                fw.write("0");
            }
            catch (IOException ioe) {
                System.out.println("NoSuchElementException in oldReader");
            }
        }
        catch (IOException e) {
            System.out.println("IOException in oldReader");
        }
        finally {
            fr.close();
            fw.close();
            scanner.close();
        }
        //
    }

    public void totalWriter() throws IOException{
        // Writing total data
        try {
            fw = new FileWriter(file, false);
            fw.write(timer.totalHours.toString());
        }
        catch (IOException ioe) {
            System.out.println("IOException in totalWriter");
        }
        finally {
            fw.close();
        }
    }
}
