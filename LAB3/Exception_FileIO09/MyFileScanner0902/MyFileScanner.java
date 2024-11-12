package MyFileScanner0902;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileScanner {
    private String csvFilePath;
    private String jsonFilePath;
    private CSVToJsonConverter converter;


    public MyFileScanner(String csvFilePath, String jsonFilePath, CSVToJsonConverter converter) {
        this.csvFilePath = csvFilePath;
        this.jsonFilePath = jsonFilePath;
        this.converter = converter;
    }

    public void process() {
        //Implement your code
        List<String> headers = new ArrayList<>();
        List<String> csvLines = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File(csvFilePath))){
            if(scanner.hasNextLine()) {
                String headerLine = scanner.nextLine();
                Scanner headerScanner = new Scanner(headerLine);
                headerScanner.useDelimiter(",");

                while(headerScanner.hasNext()) {
                    headers.add(headerScanner.next());
                }
                headerScanner.close();
            }
            while(scanner.hasNextLine()) {
                csvLines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        String jsonOutput = converter.convertToJson(csvLines,headers);
        writeJsonToFile(jsonOutput);
    }

    private void writeJsonToFile(String jsonOutput) {
        //Implement your code
        try (FileWriter writer = new FileWriter(jsonFilePath)) {
            writer.write(jsonOutput);
            System.out.println("JSON file content (" + jsonFilePath + "):\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}

