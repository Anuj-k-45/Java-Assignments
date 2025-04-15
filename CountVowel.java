import java.util.*;

public class CountVowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] vowels = {"A", "E", "I", "O", "U"};
        String[] sentences = new String[5];
        int totalVowelWords = 0;
        StringBuilder[] vowelWords = new StringBuilder[5];

        for (int i = 0; i < 5; i++) {
            vowelWords[i] = new StringBuilder();
        }

        System.out.println("Enter 5 sentences:");
        for (int i = 0; i < 5; i++) {
            sentences[i] = scanner.nextLine();
        }

        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            for (String word : words) {
                while (!word.isEmpty() && !Character.isLetter(word.charAt(0))) {
                    word = word.substring(1);
                }
                while (!word.isEmpty() && !Character.isLetter(word.charAt(word.length() - 1))) {
                    word = word.substring(0, word.length() - 1);
                }

                if (word.isEmpty()) continue;

                char firstChar = Character.toUpperCase(word.charAt(0));

                for (int i = 0; i < vowels.length; i++) {
                    if (firstChar == vowels[i].charAt(0)) {
                        if (vowelWords[i].length() > 0) {
                            vowelWords[i].append(", ");
                        }
                        vowelWords[i].append(word);
                        totalVowelWords++;
                        break;
                    }
                }
            }
        }

        System.out.println("Total no. of words starting with vowels: " + totalVowelWords);
        for (int i = 0; i < vowels.length; i++) {
            if (vowelWords[i].length() > 0) {
                System.out.println(vowels[i] + " - " + vowelWords[i]);
            }
        }

        scanner.close();
    }
}