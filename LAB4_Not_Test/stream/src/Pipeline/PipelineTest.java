package Pipeline;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipelineTest {

    public static void main(String[] args) {

        List<Object> data = new ArrayList<>();

        data.add(10);

        data.add("str");

        data.add(-5.1);

        data.add(-100);

        data.add("var");

        List<String> strData = data.stream()
                .distinct() // 중복 제거
                .filter(obj -> obj instanceof String) // String 유형 필터링
                .map(obj -> (String) obj) // String으로 캐스팅
                .collect(Collectors.toList()); // 결과를 List로 수집



        System.out.println(strData);

    }

}