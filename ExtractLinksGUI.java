import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class ExtractLinksGUI extends JFrame {
    private JTextArea textArea;
    private JButton openButton;

    public ExtractLinksGUI() {
        setTitle("HTML Link Extractor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        add(openButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void selectFileAndExtractLinks() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExtractLinksGUI().setVisible(true));
    }
}