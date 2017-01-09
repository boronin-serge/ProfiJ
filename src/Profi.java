import java.io.*;
import java.util.Scanner;

/**
 * Created by Boronin on 1/1/2017.
 */
public class Profi {
    public static void main(String[] args) throws IOException {

        IOMaster ioMaster = new IOMaster();
        ioMaster.timer = new Timer();
        ioMaster.file = new File("src/data.txt");     // bind file and object of File
        try {
            ioMaster.oldReader();
            if (ioMaster.file.exists()) {
                ioMaster.todayReader();
                ioMaster.totalWriter();
            }
            else {
                System.out.println("File not found");
            }
        }
        catch (IOException ioe) {
            System.out.println("File have troubles in reading");
        }

        System.out.println("You worked " + ioMaster.timer.totalHours + " hours");
        System.out.println("In order to become a Pro left " + (10000 - ioMaster.timer.totalHours) + " hours");
        ioMaster.timer.printTodayStat();
        ioMaster.timer.printCommonStat();
        ioMaster.timer.pringProgressLine();
    }

}


