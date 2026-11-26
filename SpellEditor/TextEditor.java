import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.*;

public class TextEditor extends JFrame {
    protected final JTextArea text = new JTextArea(20, 50);
    private final JFileChooser chooser = new JFileChooser();

    public TextEditor() {
        super("Текстовый редактор");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem save = new JMenuItem("Сохранить");

        open.addActionListener(event -> openFile());
        save.addActionListener(event -> saveFile());

        fileMenu.add(open);
        fileMenu.add(save);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(new JScrollPane(text));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void openFile() {
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                Path path = chooser.getSelectedFile().toPath();
                text.setText(Files.readString(path));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Не удалось открыть файл");
            }
        }
    }

    private void saveFile() {
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                Path path = chooser.getSelectedFile().toPath();

                if (Files.exists(path) && JOptionPane.showConfirmDialog(
                        this, "Заменить существующий файл?", "Сохранение",
                        JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                    return;
                }

                Files.writeString(path, text.getText());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Не удалось сохранить файл");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}
