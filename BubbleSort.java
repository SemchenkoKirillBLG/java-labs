import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 3};

        for (int end = numbers.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }
}
