import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class LayoutDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Менеджеры компоновки");
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(new JButton("Первая кнопка"));
            panel.add(new JButton("Вторая кнопка"));
            panel.add(new JButton("Третья кнопка"));

            frame.add(panel, BorderLayout.NORTH);
            frame.add(new JTextArea("Центральная область"), BorderLayout.CENTER);
            frame.add(new JLabel("Нижняя область"), BorderLayout.SOUTH);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
