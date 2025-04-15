import java.util.Random;
import java.util.regex.*;

public class PatternSearch {
    public static String generateRandomString(int length) {
        char[] characters = {'A', 'G', 'C', 'T'};
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            sb.append(characters[rand.nextInt(characters.length)]);
        }
        
        return sb.toString();
    }
    
    public static void searchPattern(String text, String pattern) {
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);
        
        int count = 0;
        
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + ": Start index = " + matcher.start() + ", End index = " + matcher.end());
        }
        
        if (count == 0) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("Total occurrences found: " + count);
        }
    }

    public static void main(String[] args) {
        String randomString = generateRandomString(100);
        System.out.println("Generated random string: " + randomString);
        
        String pattern = "AGG";
        
        searchPattern(randomString, pattern);
    }
}