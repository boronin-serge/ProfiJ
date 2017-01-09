/**
 * Created by Boronin on 1/9/2017.
 */
public class Timer {
    public Float totalHours;
    public Float todayHours;
    public Float completeHours;

    void printTodayStat()
    {
        float delta = 10000 - (todayHours + completeHours);
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

    void printCommonStat() {
        float delta = 10000 - totalHours;
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

    void pringProgressLine() {
        float yourProgress = totalHours * 100 / 10000;
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
