import java.io.*;
import java.util.*;

class Editor {
    String file_name;
    List<String> para;

    public Editor(String file_name) throws IOException {
        this.file_name = file_name;
        this.para = read_para();
    }

    public List<String> read_para() throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(file_name);

        if (!file.exists()) {
            System.out.println("File not found: " + file_name + ". Creating a new one.");
            file.createNewFile();
            return lines;
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        return lines;
    }
    

    public void editSentence(int lineNumber) throws IOException {
        if (lineNumber < 1 || lineNumber > para.size()) {
            System.out.println("Invalid line number.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String sentence = para.get(lineNumber - 1);
        System.out.println("Current sentence: " + sentence);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add new word");
            System.out.println("2. Modify existing word spelling");
            System.out.println("3. Delete a word");
            System.out.println("4. Add punctuation");
            System.out.println("5. Exit editing");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter the word to add: ");
                String newWord = scanner.nextLine();
                System.out.print("Enter index where to insert : ");
                int position = scanner.nextInt();
                scanner.nextLine();
                List<String> words = new ArrayList<>(Arrays.asList(sentence.split(" ")));
                words.add(position, newWord);
                sentence = String.join(" ", words);
            } 
            
            else if (choice == 2) {
                System.out.print("Enter the word to modify: ");
                String oldWord = scanner.nextLine();
                System.out.print("Enter the new spelling: ");
                String newWord = scanner.nextLine();
                sentence = sentence.replace(oldWord, newWord);
            } 
            
            else if (choice == 3) {
                System.out.print("Enter the word to delete: ");
                String wordToDelete = scanner.nextLine();
                sentence = sentence.replaceAll("\\b" + wordToDelete + "\\b", "").trim();
            }
            
            else if (choice == 4) {
                System.out.print("Enter punctuation to add: ");
                String punctuation = scanner.nextLine();
                sentence += punctuation;
            } 
            
            else if (choice == 5) {
                break;
            } 
            
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        
        para.set(lineNumber - 1, sentence);
        appendModifiedpara();
        System.out.println("Updated sentence: " + sentence);
    }

    private void appendModifiedpara() throws IOException {
        FileWriter writer = new FileWriter(file_name, true);
        writer.write("\nModified para:\n");
        for (String line : para) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public void generateSummary(String summaryFile) throws IOException {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        Set<String> prepositions = new HashSet<>(Arrays.asList("in", "on", "at", "by", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "over", "under", "next", "beside", "between", "beyond"));
        FileWriter writer = new FileWriter(summaryFile);
        
        for (int i = 0; i < para.size(); i++) {
            String line = para.get(i);
            int numVowels = 0;
            int numPrepositions = 0;

            for (char ch : line.toCharArray()) {
                if (vowels.contains(ch)) {
                    numVowels++;
                }
            }
            String[] words = line.toLowerCase().split("\\s+");
            for (String word : words) {
                if (prepositions.contains(word)) {
                    numPrepositions++;
                }
            }
            writer.write("Line " + (i + 1) + ": Vowels=" + numVowels + ", Prepositions=" + numPrepositions + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String file_name = "para.txt";
        String summaryFile = "summary.txt";
        Editor editor = new Editor(file_name);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter line number to edit (0 to exit): ");
            int lineNumber = scanner.nextInt();
            if (lineNumber == 0) break;
            editor.editSentence(lineNumber);
        }
        
        editor.generateSummary(summaryFile);
        System.out.println("Summary generated in " + summaryFile);
    }
}