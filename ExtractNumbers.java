import java.util.*;

public class ExtractNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sentences = new String[5];

        System.out.println("Enter 5 sentences:");
        for (int i = 0; i < 5; i++) {
            sentences[i] = scanner.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            String sentence = sentences[i] + " ";
            String sentence_digits = "";
            String curr = "";

            for (char ch : sentence.toCharArray()) {
                if (Character.isDigit(ch)) {
                    curr += ch;
                } else {
                    if (!curr.isEmpty()) {
                        if (!sentence_digits.isEmpty()) {
                            sentence_digits += ", ";
                        }
                        sentence_digits += curr;
                        curr = "";
                    }
                }
            }

            if (sentence_digits.isEmpty()) {
                sentence_digits = "NA";
            }

            System.out.println("Sentence" + (i + 1) + " - " + sentence_digits);
        }

        scanner.close();
    }
}