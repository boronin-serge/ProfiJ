import java.io.*;
import java.util.Scanner;

/**
 * Created by Boronin on 1/1/2017.
 */
public class Profi {
    public static void main(String[] args) throws IOException {
        String sep = File.separator;
        File file = new File("src/data.txt");     // bind file and object of File
        FileReader fr = null;
        FileWriter fw = null;

        Float totalHours = null;
        Float todayHours = null;
        Float completeHours = null;
        try {
            fr = new FileReader(file);
            Scanner scanner = new Scanner(fr);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Reading old data
            completeHours = scanner.nextFloat();
            //

            if (file.exists()) {
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

                // Reading today data
                todayHours = new Float(0.0);
                try {
                    todayHours = Float.parseFloat(consoleInput.readLine());
                }
                catch (NumberFormatException nfe) {
                    System.out.println("You didn't enter value");
                }
                totalHours = todayHours + completeHours;
                //

                // Writing total data
                try {
                    fw = new FileWriter(file, false);
                    fw.write(totalHours.toString());
                }
                catch (IOException ioe) {
                    System.out.println("File have troubles in writing");
                }
                finally {
                    fw.close();
                }
            }
            else {
                System.out.println("File not found");
            }
        }
        catch (IOException ioe) {
            System.out.println("File have troubles in reading");
        }
        finally {
            fr.close();
        }
        System.out.println("You worked " + totalHours + " hours");
        System.out.println("In order to become a Pro left " + (10000 - totalHours) + " hours");
        printTodayStat(todayHours, completeHours);
        printCommonStat(totalHours);
        pringProgressLine(totalHours);
    }

    static void printTodayStat(float todayHours, float buffer)
    {
        float delta = 10000 - (todayHours + buffer);
        int iYears = 0;
        float fYears = 0;
        float partOfyear = 0;
        int month = 0;
        if (todayHours != 0) {
            fYears = (delta / todayHours) / 365;
            iYears = (int)fYears;
            partOfyear = fYears - iYears;
            month = (int)(12 * partOfyear);
            System.out.println("--------------------------------------------------");
            System.out.print(todayHours + " hours (like today) every day - " + (int)delta / todayHours + " days (~");
            System.out.print(iYears + " years ");
            System.out.println( month + " months)");
        }
        else {
            System.out.println("--------------------------------------------------");
            System.out.println("If you won't work you will be unemployed");
        }
    }

    static void printCommonStat(float hours) {
        float delta = 10000 - hours;
        int iYears = 0;
        float fYears = 0;
        float partOfyear = 0;
        int month = 0;
        System.out.println("--------------------------------------------------");
        for (int i = 2; i < 8; i++) {
            fYears = (delta / i) / 365;
            iYears = (int)fYears;
            partOfyear = fYears - iYears;
            month =(int)(12 * partOfyear);
            System.out.print(i + " hours every day - " + (int)delta / i + " days (~");
            System.out.print(iYears + " years ");
            System.out.println(month + " months)");
        }
    }

    static void pringProgressLine(float hours) {
        float yourProgress = hours * 100 / 10000;
        System.out.println("");
        System.out.println("You are professional on " + yourProgress + "%");
        for (int i = 0; i < 100; i+=2) {
            if (i < yourProgress) {
                System.out.print("|");
            }
            else {
                System.out.print(".");
            }
        }
        System.out.println("");
    }
}


