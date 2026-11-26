import java.io.File;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlTree {
    private static DefaultMutableTreeNode buildTree(Element element) {
        DefaultMutableTreeNode branch =
                new DefaultMutableTreeNode(element.getTagName());

        for (Node child = element.getFirstChild(); child != null;
                child = child.getNextSibling()) {
            if (child instanceof Element) {
                branch.add(buildTree((Element) child));
            } else if (child.getNodeType() == Node.TEXT_NODE
                    || child.getNodeType() == Node.CDATA_SECTION_NODE) {
                String value = child.getNodeValue().trim();
                if (!value.isEmpty()) {
                    branch.add(new DefaultMutableTreeNode(value));
                }
            }
        }

        return branch;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            try {
                File file = chooser.getSelectedFile();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setFeature(
                        "http://apache.org/xml/features/disallow-doctype-decl", true);

                Element root = factory.newDocumentBuilder()
                        .parse(file).getDocumentElement();

                JFrame frame = new JFrame("Дерево XML");
                frame.add(new JScrollPane(new JTree(buildTree(root))));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Не удалось прочитать XML-файл");
            }
        });
    }
}