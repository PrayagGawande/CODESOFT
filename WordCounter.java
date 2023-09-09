import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class WordCounter 
{
    public static void main(String[] args) 
    {
        try 
        {
            System.out.println("Enter text or provide a file path: "); // Prompt the user for input
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in)); // Read input from the user
            String input = reader.readLine();    // Check if the input is a file path
            if (input != null && input.length() > 0) 
            {
                if (input.endsWith(".txt")) 
                {
                    input = readTextFromFile(input);   // Read text from a file
                }
                String[] words = input.split("[\\s\\p{Punct}]+");   // Split the input into words
                int wordCount = words.length;    // Initialize a counter for word count
                // Display the word count to the user
                System.out.println("Total word count: " + wordCount);
                // Optional: Display the unique word count
                Set<String> uniqueWords = new HashSet<>();
                for (String word : words) 
                {
                    uniqueWords.add(word);
                }
                System.out.println("Unique word count: " + uniqueWords.size());
            } 
            else 
            {
                System.out.println("No input provided.");
            }
        } 
        catch (IOException e) 
        {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
    // Read text from a file
    private static String readTextFromFile(String filePath) throws IOException 
    {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                content.append(line).append(" ");
            }
        }
        return content.toString();
    }
}
