import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");

        try {
            int year = Integer.parseInt(scanner.nextLine().trim());

            if (year <= 0) {
                throw new IllegalArgumentException("Год должен быть больше нуля");
            }

            boolean leap = year % 400 == 0
                    || (year % 4 == 0 && year % 100 != 0);

            System.out.println(leap ? "Високосный год" : "Обычный год");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите целое число");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
