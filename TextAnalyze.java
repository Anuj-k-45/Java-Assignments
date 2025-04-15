import java.awt.*;
import java.awt.event.*;

public class TextAnalyze {
    Frame frame;
    TextArea textArea;
    Label resultLabel;
    Checkbox bgCheckBox;
    Panel buttonPanel;

    public TextAnalyze() {
        frame = new Frame("Text Analyzer");
        frame.setSize(500, 350);
        frame.setLayout(new BorderLayout());

        textArea = new TextArea(5, 40);
        frame.add(textArea, BorderLayout.NORTH);

        buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        Button vowelButton = new Button("Count Vowels");
        Button consonantButton = new Button("Count Consonants");
        Button punctuationButton = new Button("Count Punctuations");
        Button capitalizeButton = new Button("Capitalize");
        
        buttonPanel.add(vowelButton);
        buttonPanel.add(consonantButton);
        buttonPanel.add(punctuationButton);
        buttonPanel.add(capitalizeButton);
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(2, 1));

        resultLabel = new Label("Result: ", Label.CENTER);
        bgCheckBox = new Checkbox("Change Background");
        Panel checkboxPanel = new Panel();
        checkboxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        checkboxPanel.add(bgCheckBox);

        bottomPanel.add(resultLabel);
        bottomPanel.add(checkboxPanel);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        vowelButton.addActionListener(e -> countVowels());
        consonantButton.addActionListener(e -> countConsonants());
        punctuationButton.addActionListener(e -> countPunctuations());
        capitalizeButton.addActionListener(e -> capitalizeText());
        bgCheckBox.addItemListener(e -> changeBackground());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
    }

    public void countVowels() {
        String text = textArea.getText().toLowerCase();
        int count = 0;
        for (char c : text.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) count++;
        }
        resultLabel.setText("Vowels: " + count);
    }

    public void countConsonants() {
        String text = textArea.getText().toLowerCase();
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) && "aeiou".indexOf(c) == -1) count++;
        }
        resultLabel.setText("Consonants: " + count);
    }

    public void countPunctuations() {
        String text = textArea.getText();
        int count = 0;
        for (char c : text.toCharArray()) {
            if (".,!?;:'\"(){}[]-".indexOf(c) != -1) count++;
        }
        resultLabel.setText("Punctuations: " + count);
    }

    public void capitalizeText() {
        textArea.setText(textArea.getText().toUpperCase());
    }

    public void changeBackground() {
        if (bgCheckBox.getState()) {
            textArea.setBackground(Color.CYAN);
        } else {
            textArea.setBackground(Color.WHITE);
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[]args) {
        new TextAnalyze().show();
    }
}