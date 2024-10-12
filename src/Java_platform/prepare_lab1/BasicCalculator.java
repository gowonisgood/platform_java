package Java_platform.prepare_lab1;
import java.util.Scanner;


public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                String[] input = new String[3];
                String src = sc.nextLine();
                Scanner in = new Scanner(src);

                int j = 0;
                while (in.hasNext()) {
                    input[j] = in.next();
                    j++;
                }

                double result = 0;
                if (input[2] != null) {
                    String op = input[2];
                    double a = Double.parseDouble(input[0]);
                    double b = Double.parseDouble(input[1]);

                    switch (op) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                            if (b == 0) throw new ArithmeticException();
                            result = a / b;
                            break;
                        case "^":
                            result = Math.pow(a, b);
                            break;
                        case "%":
                            result = a % b;
                            break;
                        default:
                            throw new Exception();

                    }
                } else {
                    String op = input[1];
                    double a = Double.parseDouble(input[0]);

                    switch (op) {
                        case "sqrt":
                            result = Math.sqrt(a);
                            break;
                        default:
                            throw new Exception();

                    }
                }
                System.out.printf("Result: %.2f\n", result);

            }catch(
                    ArithmeticException e)

            {
                System.out.println("Division by zero.");
            }
            catch(
                    NumberFormatException e)

            {
                System.out.println("Invalid number format.");
            }
            catch(
                    Exception e)

            {
                System.out.println("Invalid operator.");
            }
        }

    }
}


