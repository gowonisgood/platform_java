package filterCountdistinct0801;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterCountDistinctTest {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {

            data.add(sc.nextInt());

        }

        sc.close();

        System.out.println(data.stream()
                        .filter(x->x<10)
                        .collect(Collectors.toList()));
//.count()개수 세기
                System.out.println(data.stream()
                        .filter(x->x<10)
                        .count());

                        System.out.println(data.stream()
                            .filter(x->x<10)
                                .distinct()
                                .collect(Collectors.toList()));


//.distinct() : 필터 뒤에
                                System.out.println(data.stream()
                                        .filter(x->x>=10)
                                        .collect(Collectors.toList()));

                                        System.out.println(data.stream()
                                            .filter(x->x>=10)
                                                .count());

                                                System.out.println(data.stream()
                                                        .filter(x->x>=10)
                                                        .distinct()
                                                        .collect(Collectors.toList()));

    }

}
