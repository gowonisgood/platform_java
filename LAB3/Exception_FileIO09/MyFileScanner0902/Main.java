package MyFileScanner0902;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "C:/Users/gowon/Desktop/Exeption_File_IO/src/MyFileScanner0902/input.csv";
        String jsonFilePath = "C:/Users/gowon/Desktop/Exeption_File_IO/src/MyFileScanner0902/output.json";

        CSVToJsonConverter converter = new CSVToJsonConverterImpl();
        MyFileScanner fileScanner = new MyFileScanner(csvFilePath, jsonFilePath, converter);
        fileScanner.process();
    }
}
