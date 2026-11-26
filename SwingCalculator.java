import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingCalculator::createWindow);
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Калькулятор");
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField first = new JTextField(10);
        JTextField second = new JTextField(10);
        JLabel result = new JLabel("Результат");

        panel.add(new JLabel("Первое число"));
        panel.add(first);
        panel.add(new JLabel("Второе число"));
        panel.add(second);

        for (String operation : new String[]{"+", "-", "*", "/"}) {
            JButton button = new JButton(operation);
            button.addActionListener(event -> {
                try {
                    double a = Double.parseDouble(first.getText().trim());
                    double b = Double.parseDouble(second.getText().trim());
                    result.setText(String.valueOf(calculate(a, b, operation)));
                } catch (NumberFormatException e) {
                    result.setText("Введите два числа");
                } catch (ArithmeticException e) {
                    result.setText(e.getMessage());
                }
            });
            panel.add(button);
        }

        panel.add(new JLabel("Ответ"));
        panel.add(result);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static double calculate(double a, double b, String operation) {
        switch (operation) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неизвестная операция");
        }
    }
}
