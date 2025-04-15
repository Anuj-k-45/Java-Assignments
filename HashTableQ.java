import java.util.Hashtable;
import java.util.Map;

public class HashTableQ {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable= new Hashtable<>(11);
        
        int[] keys = {23, 24, 36, 16, 17, 7, 11, 1, 14, 29, 20, 56, 42};
        
        String[] numberWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six", "twenty-seven", "twenty-eight", "twenty-nine", "thirty", "thirty-one", "thirty-two", "thirty-three", "thirty-four", "thirty-five", "thirty-six", "thirty-seven", "thirty-eight", "thirty-nine", "forty", "forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven", "forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two", "fifty-three", "fifty-four", "fifty-five", "fifty-six"};

        for (int key : keys) {
            if (key >= 0 && key < numberWords.length) {
                hashtable.put(key, numberWords[key]);
            }
        }
        
        for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}