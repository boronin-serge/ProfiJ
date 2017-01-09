import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Boronin on 1/1/2017.
 */
public class Profi {
    public static void main(String[] args) throws IOException {

        IOMaster ioMaster = new IOMaster();
        ioMaster.printHeader();
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
        ioMaster.printBody();
        ioMaster.timer.printTodayStat();
        ioMaster.timer.printCommonStat();
        ioMaster.timer.pringProgressLine();

    }

}


