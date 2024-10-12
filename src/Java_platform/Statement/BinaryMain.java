package Java_platform.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int oldN=N;
        sc.nextLine();

        ArrayList<Integer> result = new ArrayList<>();

        while(N!=0){
            result.add(N%2);
            N/=2;
        }

        System.out.print("Number "+oldN+" in Binary Number: ");
        for(int i=result.size()-1;i>=0;i--){
            System.out.print(result.get(i));
        }


    }
}
