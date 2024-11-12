package MyFileScanner0902;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVToJsonConverterImpl implements CSVToJsonConverter {

    @Override
    public String convertToJson(List<String> csvLines, List<String> headers) {
        //Implement your code
        StringBuilder jsonString = new StringBuilder();

        jsonString.append("[\n");

        for(int i=0;i<csvLines.size();i++) {
            /*1.시작*/
            String csvLine = csvLines.get(i);
            jsonString.append("\t{");

            Scanner sc = new Scanner(csvLine);
            sc.useDelimiter(",");
            /*--------------*/

            /*2.json 형식으로 추가*/
            for(int j=0;j<headers.size();j++) {
                String header = headers.get(j);
                String value = sc.hasNext() ? sc.next().trim() : "";

                //타입추론
                Class<?> inferredType = inferColumnTypes(csvLines.get(0),headers).get(j);
                String formattedValue = formatValue(value,inferredType);

                jsonString.append("\n\t\t\"").append(header).append("\": ").append(formattedValue);

                //마지막 열이 아니면 쉼표 추가
                if(j < headers.size()-1) {
                    jsonString.append(",");
                }
            }

            jsonString.append("\n\t}");
            if(i < csvLines.size()-1) {
                jsonString.append(",");
            }
            jsonString.append("\n");

            /*--------------*/


        }
        /*3.끝*/
        jsonString.append("]");
        return jsonString.toString();
        /*--------------*/

    }

    private List<Class<?>> inferColumnTypes(String firstRow, List<String> headers) {
        List<Class<?>> columnTypes = new ArrayList<>();
        try (Scanner scanner = new Scanner(firstRow)) {
            scanner.useDelimiter(",");

            for (int i = 0; i < headers.size(); i++) {
                if (scanner.hasNext()) {
                    String value = scanner.next().trim();
                    columnTypes.add(guessType(value));
                } else {
                    // no value is present for a column
                    columnTypes.add(String.class);
                }
            }
        }
        return columnTypes;
    }

    private Class<?> guessType(String value) {
        if (value.matches("-?\\d+")) {
            return Integer.class;
        } else if (value.matches("-?\\d+(\\.\\d+)?")) {
            return Double.class;
        } else {
            return String.class;
        }
    }

    private String formatValue(String value, Class<?> type) {
        if (type == Integer.class || type == Double.class) {
            return value;
        } else {
            // Adds double quotes or Replaces any existing double quotes
            return "\"" + value.replace("\"", "\\\"") + "\"";
        }
    }
}
