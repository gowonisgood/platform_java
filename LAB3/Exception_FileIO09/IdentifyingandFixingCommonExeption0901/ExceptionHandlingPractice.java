package IdentifyingandFixingCommonExeption0901;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;


public class ExceptionHandlingPractice {

    public static void divideNumbers(int a, int b) {
        try{
            int result = a / b;
            System.out.println("Result: " + result);
        } catch(ArithmeticException e){
            System.out.println("Error: Cannot divide by zero.");
        }
    }

    public static void accessArray(int[] array, int index) {
        try {
            int value = array[index];
            System.out.println("Array value: " + value);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.printf("Error: %d is out of bounds for array length %d.\n",index,array.length);
        }
    }

    public static void parseInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            System.out.println("Parsed integer: " + value);
        }catch (NumberFormatException e){
            System.out.printf("Error: '%s' is not a valid integer.\n",input);
        }
    }

    public static void getStringLength(String text) {
        try {
            int length = text.length();
            System.out.println("String length: " + length);
        }catch (NullPointerException e){
            System.out.println("Error: Cannot get length of a null string.\n");
        }
    }

    public static void readFileContent(String filePath) {
        try {
            File file = new File(filePath);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }catch (FileNotFoundException e){
            System.out.printf("Error: File not found at '%s'\n",filePath);
        }
    }

    public static void stringToBytes(String text, String encoding) {
        try {
            byte[] bytes = text.getBytes(encoding);

            System.out.println("Converted string to bytes: " + java.util.Arrays.toString(bytes));
        }catch (UnsupportedEncodingException e){
            System.out.println("Error: Unsupported encoding specified.");
        }
    }
}