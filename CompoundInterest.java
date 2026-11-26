import java.util.Locale;
import java.util.Scanner;

public class CompoundInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("1 — найти итоговое число, 2 — найти процент");
        int mode = scanner.nextInt();

        if (mode != 1 && mode != 2) {
            System.out.println("Выберите 1 или 2");
            return;
        }

        System.out.println(mode == 1
                ? "Введите начальное число, процент и число периодов"
                : "Введите начальное число, конечное число и число периодов");

        double start = scanner.nextDouble();
        double value = scanner.nextDouble();
        int periods = scanner.nextInt();

        if (start <= 0 || periods <= 0
                || (mode == 1 && value < -100)
                || (mode == 2 && value < 0)) {
            System.out.println("Некорректные данные");
            return;
        }

        if (mode == 1) {
            double result = start * Math.pow(1 + value / 100, periods);
            System.out.printf(Locale.US, "Итог: %.2f%n", result);
        } else {
            double rate = (Math.pow(value / start, 1.0 / periods) - 1) * 100;
            System.out.printf(Locale.US, "Процент за период: %.2f%%%n", rate);
        }
    }
}
