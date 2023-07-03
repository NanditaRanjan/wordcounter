import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text or provide a file path:");
        String input = scanner.nextLine();
        
        String text = "";
        if (input.endsWith(".txt")) {
            
            try {
                text = readFile(input);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            
            text = input;
        }
        
        
        String[] words = text.split("\\s+|\\p{Punct}");
        
        
        int totalWords = words.length;
        int uniqueWords = 0;
        
        
        Map<String, Integer> wordFrequencies = new HashMap<>();
        
        
        for (String word : words) {
            if (!word.isEmpty()) {
                
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }
        
        
        uniqueWords = wordFrequencies.size();
        
        
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        
        
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        
        return content.toString();
    }
}
