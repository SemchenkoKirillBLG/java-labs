import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SpellEditor extends TextEditor {
    public SpellEditor() {
        setTitle("Текстовый редактор с автозаменой");

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_SPACE) {
                    checkSpelling();
                }
            }
        });
    }

    private void checkSpelling() {
        String original = text.getText();

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() {
                return original.replaceAll(
                        "(?U)\\bпривте\\b(?=\\s)", "привет");
            }

            @Override
            protected void done() {
                try {
                    String corrected = get();

                    if (!corrected.equals(original) && text.getText().equals(original)) {
                        int caret = text.getCaretPosition();
                        text.setText(corrected);
                        text.setCaretPosition(caret);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (java.util.concurrent.ExecutionException e) {
                    System.err.println("Ошибка проверки текста: " + e.getCause());
                }
            }
        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SpellEditor().setVisible(true));
    }
}