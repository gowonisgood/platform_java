package Java_platform.Statement;

import java.util.Scanner;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class DateTimeCalculator_old {
    public static void printOption(){
        System.out.println("1.Diff");
        System.out.println("2.Add/Sub");
        System.out.println("3.Week");
        System.out.println("4.Exit");
    }

    public static void diff(String first, String second){
        Date date1 = strToDate(first);
        Date date2 = strToDate(second);
        int dif = (int)(date2.getTime() - date1.getTime())/(24*60*60*1000);
        System.out.println("Menu: first date (YYYY-MM-DD): second date (YYYY-MM-DD): Diff:"+dif+" days");
    }

    public static void dateCal(String daystr, int N){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = strToDate(daystr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, N);
        System.out.println("Menu: date (YYYY-MM-DD): days to add/subtract: New date: "+sdf.format(cal.getTime()));
    }

    public static void dayOfWeek(String daystr){
        Date date = strToDate(daystr);
        if(date==null){return;}
        int iday = date.getDay();
        switch(iday){
            case 0: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: SUNDAY"); break;
            case 1: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: MONDAY"); break;
            case 2: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: TUESDAY"); break;
            case 3: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: WEDNESDAY"); break;
            case 4: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: THURSDAY"); break;
            case 5: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: FRIDAY"); break;
            case 6: System.out.println("Menu: date (YYYY-MM-DD): Day of the week: SATURDAY"); break;
        }

    }

    public static Date strToDate(String daystr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(daystr);
            //if(date.getDay()<0||date.getDay()>=31||date.getMonth()<0||date.getMonth()>11) throw new Exception();
            return date;
        } catch (Exception e) {
            Date date = null;
            System.out.println("Menu: date (YYYY-MM-DD): Invalid date format.");
            return date;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        while(true){
            printOption();
            op = sc.nextInt();
            sc.nextLine();
            if(op==4) {
                System.out.println("Menu: Exiting...");
                break;
            }
            switch(op){
                case 1:{
                    String firstDate = sc.nextLine();
                    String secondDate = sc.nextLine();
                    diff(firstDate, secondDate);
                    break;
                }
                case 2: {
                    String daystr = sc.nextLine();
                    int N = sc.nextInt();
                    sc.nextLine();
                    dateCal(daystr, N);
                    break;
                }
                case 3: {
                    String dayStr = sc.nextLine();
                    dayOfWeek(dayStr);
                    break;
                }
            }
        }
        sc.close();

    }
}
