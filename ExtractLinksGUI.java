import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class ExtractLinksGUI {
    private JFrame frame;
    private JTextArea textArea;
    private JButton openButton;

    public ExtractLinksGUI() {
        frame = new JFrame("HTML Link Extractor");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        openButton = new JButton("Select HTML File");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFileAndExtractLinks();
            }
        });

        frame.add(openButton, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void selectFileAndExtractLinks() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(frame); // use frame here
        
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            extractLinks(file);
        }
    }

    private void extractLinks(File file) {
        textArea.setText(""); 
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            textArea.setText("Error reading file.");
            return;
        }

        String html = content.toString();
        ArrayList<String> links = new ArrayList<>();

        Pattern pattern = Pattern.compile("<a[^>]+href=[\"']?([^\"' >]+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            links.add(matcher.group(1));
        }

        if (links.isEmpty()) {
            textArea.setText("No links found.");
        } else {
            textArea.append("Links found:\n");
            for (String link : links) {
                textArea.append(link + "\n");
            }
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExtractLinksGUI gui = new ExtractLinksGUI();
            gui.show();
        });
    }
}
