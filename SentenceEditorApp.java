import java.util.*;

class Editor {
    private StringBuilder sentence;

    public Editor(String sentence) {
        this.sentence = new StringBuilder(sentence);
    }

    public void displaySentence() {
        System.out.println("Current sentence: " + sentence.toString());
    }

    public void addWord(String word) {
        sentence.append(" " + word);
        System.out.println("Word added successfully.");
    }

    public void modifyWord(String oldWord, String newWord) {
        int index = sentence.indexOf(oldWord);
        if (index != -1) {
            sentence.replace(index, index + oldWord.length(), newWord);
            System.out.println("Word modified successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }

    public void deleteWord(String word) {
        int index = sentence.indexOf(word);
        if (index != -1) {
            sentence.delete(index, index + word.length());
            System.out.println("Word deleted successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }

    public void addPunctuation(String punctuation) {
        if (!sentence.toString().endsWith(punctuation)) {
            sentence.append(punctuation);
            System.out.println("Punctuation added successfully.");
        } else {
            System.out.println("Punctuation is already present.");
        }
    }

    public void editSentence() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displaySentence();
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a word");
            System.out.println("2. Modify a word");
            System.out.println("3. Delete a word");
            System.out.println("4. Add punctuation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the word to add: ");
                    String newWord = scanner.nextLine();
                    addWord(newWord);
                    break;
                case 2:
                    System.out.print("Enter the word to modify: ");
                    String oldWord = scanner.nextLine();
                    System.out.print("Enter the new word: ");
                    String newModifiedWord = scanner.nextLine();
                    modifyWord(oldWord, newModifiedWord);
                    break;
                case 3:
                    System.out.print("Enter the word to delete: ");
                    String wordToDelete = scanner.nextLine();
                    deleteWord(wordToDelete);
                    break;
                case 4:
                    System.out.print("Enter punctuation to add: ");
                    String punctuation = scanner.nextLine();
                    addPunctuation(punctuation);
                    break;
                case 5:
                    System.out.println("Exiting editor.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class SentenceEditorApp {
    public static void main(String[] args) {
        Editor editor = new Editor("My name is Anuj Kaushal");
        editor.editSentence();
    }
}