package Java_platform.prepare_lab1;
import java.util.Scanner;


public class ReverseStringMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /*char[] dst = str.toCharArray();

        for(int i=dst.length-1;i>=0;i--){
            System.out.print(dst[i]);
        }*/
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }
        sc.close();
    }
}
