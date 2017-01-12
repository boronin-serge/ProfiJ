import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Boronin on 1/1/2017.
 */
public class Profi {
    public static void main(String[] args) throws IOException {

        IOMaster ioMaster = new IOMaster();

        try {
            ioMaster.printHeader();
            ioMaster.oldReader();
            ioMaster.todayReader();
            ioMaster.totalWriter();
            ioMaster.printBody();
        }
        catch (IOException ioe) {
            System.out.println("Troubles closing the streams");
        }

        ioMaster.timer.printTodayStat();
        ioMaster.timer.printCommonStat();
        ioMaster.timer.pringProgressLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String endOfprogramm = br.readLine();
    }

}


