package Java_platform.prepare_lab1;
import java.util.Scanner;
import java.util.ArrayList;

public class BinaryMain{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        int N = sc.nextInt();
        int oldN = N;
        sc.nextLine();

        while(N!=0){
            result.add(N%2);
            N/=2;
        }

        System.out.print("Number "+oldN+" in Binary Number: ");
        for(int i=result.size()-1;i>=0;i--){
            System.out.print(result.get(i));
        }
        sc.close();

    }
}