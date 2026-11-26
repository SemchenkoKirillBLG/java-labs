import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().trim().split("\\s+");

        if (parts.length != 3) {
            System.out.println("Введите выражение через пробелы, например 2 * 6.5");
            return;
        }

        try {
            double a = Double.parseDouble(parts[0]);
            double b = Double.parseDouble(parts[2]);
            double result;

            switch (parts[1]) {
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
                    if (b == 0) {
                        System.out.println("На ноль делить нельзя");
                        return;
                    }
                    result = a / b;
                    break;
                default:
                    System.out.println("Неизвестная операция");
                    return;
            }

            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Введите числа, например 2 и 6.5");
        }
    }
}
