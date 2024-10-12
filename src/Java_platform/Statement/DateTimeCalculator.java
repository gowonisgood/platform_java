package Java_platform.Statement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;

public class DateTimeCalculator {
    public static void printOption(){
        System.out.println("1. Diff");
        System.out.println("2. Add/Sub");
        System.out.println("3. Week");
        System.out.println("4. Exit");
        System.out.print("Menu: ");
    }

    public static void diff(String first, String second){
        LocalDate date1 = strToDate(first);
        LocalDate date2 = strToDate(second);
        if(date1==null||date2==null){return;}
        long dif = ChronoUnit.DAYS.between(date1,date2);
        System.out.println("Diff: "+dif+" days");
    }

    public static void dateCal(String daystr, int N){
        LocalDate date = strToDate(daystr);
        if(date==null){return;}
        LocalDate newDate = date.plusDays(N);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("New date: "+formatter.format(newDate));
    }

    public static void dayOfWeek(String daystr){
        LocalDate date = strToDate(daystr);
        if(date==null){return;}
        System.out.println("Day of the week: "+date.getDayOfWeek());

    }

    public static LocalDate strToDate(String daystr){
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(daystr,formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return null;
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
                System.out.print("Exiting...");
                break;
            }
            switch(op){
                case 1:{
                    System.out.print("first date (YYYY-MM-DD): ");
                    String firstDate = sc.nextLine();
                    System.out.print("second date(YYYY-MM-DD): ");
                    String secondDate = sc.nextLine();
                    diff(firstDate, secondDate);
                    break;
                }
                case 2: {
                    System.out.print("date (YYYY-MM-DD):");
                    String daystr = sc.nextLine();
                    System.out.print("days to add/subtract:");
                    int N = sc.nextInt();
                    sc.nextLine();
                    dateCal(daystr, N);
                    break;
                }
                case 3: {
                    System.out.print("date (YYYY-MM-DD):");
                    String dayStr = sc.nextLine();
                    dayOfWeek(dayStr);
                    break;
                }
            }
        }
        sc.close();

    }
}
