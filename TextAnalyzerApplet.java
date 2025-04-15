import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class TextAnalyzerApplet extends Applet implements ActionListener {
    TextArea inputText;  
    Label vowelLabel, consonantLabel, punctuationLabel, capitalizedLabel;
    TextField vowelCount, consonantCount, punctuationCount, capitalizedText; 
    Button countVowels, countConsonants, countPunctuations, capitalizeText;

    public void init() {
        setLayout(new FlowLayout());

        inputText = new TextArea("Enter text here...", 5, 40);

        countVowels = new Button("Count Vowels");
        countConsonants = new Button("Count Consonants");
        countPunctuations = new Button("Count Punctuations");
        capitalizeText = new Button("Capitalize");

        vowelLabel = new Label("Vowel Count:");
        consonantLabel = new Label("Consonant Count:");
        punctuationLabel = new Label("Punctuation Count:");
        capitalizedLabel = new Label("Capitalized Text:");

        vowelCount = new TextField(10);
        consonantCount = new TextField(10);
        punctuationCount = new TextField(10);
        capitalizedText = new TextField(40);

        vowelCount.setEditable(false);
        consonantCount.setEditable(false);
        punctuationCount.setEditable(false);
        capitalizedText.setEditable(false);

        add(inputText);
        add(countVowels);
        add(countConsonants);
        add(countPunctuations);
        add(capitalizeText);

        add(vowelLabel);
        add(vowelCount);
        add(consonantLabel);
        add(consonantCount);
        add(punctuationLabel);
        add(punctuationCount);
        add(capitalizedLabel);
        add(capitalizedText);

        countVowels.addActionListener(this);
        countConsonants.addActionListener(this);
        countPunctuations.addActionListener(this);
        capitalizeText.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String text = inputText.getText(); 
        if (e.getSource() == countVowels) {
            vowelCount.setText(String.valueOf(countVowels(text)));
        } else if (e.getSource() == countConsonants) {
            consonantCount.setText(String.valueOf(countConsonants(text)));
        } else if (e.getSource() == countPunctuations) {
            punctuationCount.setText(String.valueOf(countPunctuations(text)));
        } else if (e.getSource() == capitalizeText) {
            capitalizedText.setText(text.toUpperCase());
        }
    }

    private int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c) && !"AEIOUaeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    private int countPunctuations(String text) {
        int count = 0;
        String punctuations = ".,;:!?()\"'[]{}";
        for (char c : text.toCharArray()) {
            if (punctuations.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}