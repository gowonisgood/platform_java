package forEach;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForEachTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> data = new ArrayList<>();

        data.add(sc.nextInt());

        data.add(sc.nextInt());

        data.add(sc.nextInt());

        data.add(sc.nextInt());

        data.add(sc.nextInt());

        sc.close();

        // 입력된 정수를 각각 출력
        data.stream()
                .forEach(System.out::println);

        // 입력된 정수 + 1000을 각각 출력
        data.stream()
                .map(x -> x + 1000)
                .forEach(System.out::println);

    }

}
