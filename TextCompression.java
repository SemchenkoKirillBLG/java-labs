import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class TextCompression {
    static void compress(Path source, Path target) throws IOException {
        String text = Files.readString(source);
        String[] lines = text.isEmpty() ? new String[0] : text.split("\n", -1);

        Map<String, Integer> unique = new LinkedHashMap<>();
        StringJoiner order = new StringJoiner(" ");

        for (String line : lines) {
            int index = unique.computeIfAbsent(line, key -> unique.size());
            order.add(String.valueOf(index));
        }

        String header = "Удалено дублей: " + (lines.length - unique.size());
        Files.writeString(target, header + "\n" + order + "\n"
                + String.join("\n", unique.keySet()));
    }

    static void restore(Path source, Path target) throws IOException {
        String[] parts = Files.readString(source).split("\n", 3);
        String[] unique = parts[2].split("\n", -1);
        List<String> lines = new ArrayList<>();

        if (!parts[1].isEmpty()) {
            for (String index : parts[1].split(" ")) {
                lines.add(unique[Integer.parseInt(index)]);
            }
        }

        Files.writeString(target, String.join("\n", lines));
    }

    public static void main(String[] args) throws IOException {
        Path compressed = Path.of("compressed.txt");
        compress(Path.of("input.txt"), compressed);
        restore(compressed, Path.of("restored.txt"));
    }
}
