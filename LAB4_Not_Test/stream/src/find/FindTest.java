package find;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTest {

    public static void main(String[] args) {

        List<String> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {

            data.add(sc.next());

        }

        sc.close();


        System.out.println(data.stream()
                .filter(s -> s.contains("a"))
                .findAny()
                .isPresent());

        // "a" 문자를 포함하는 첫 번째 문자열 출력
        data.stream()
                .filter(s -> s.contains("a"))
                .findFirst()
                .ifPresent(System.out::println);
    }

}
