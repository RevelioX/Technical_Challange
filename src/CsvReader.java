import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Utility class responsible for reading a text file and computing
 * the frequency of each word, It stores the results in a word-frequency map.
 */
public class CsvReader {
    /** Pattern used to remove punctuation and special characters */
    private static final Pattern PUNCTUATION = Pattern.compile("[^a-zA-Z0-9 ]");

    /** Path to the file */
    private String filename;

    /**
     * Creates a new reader for the specified file.
     *
     * @param filename path of the file to read
     */
    public CsvReader(String filename) {
        this.filename = filename;
    }

    /**
     * Reads the file line by line and builds a map containing
     * the frequency of each word.
     *
     * @return a map where the key is the word and the value is the number of occurrences
     */
    public Map<String, Integer> read(){
        Map<String, Integer> frequencies = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./" + filename))){

            String line;

            while ((line = reader.readLine()) != null){
                String normalized = normalize(line);
                processWords(normalized, frequencies);
            }

        } catch(Exception e){
            System.out.println(e);
        }

        return frequencies;
    }

    /**
     * Normalizes a line of text by converting it to lowercase
     * and removing punctuation characters.
     * @param line raw line read from the file
     * @return normalized text
     */
    private String normalize(String line) {

        line = line.toLowerCase();
        line = PUNCTUATION.matcher(line).replaceAll(" ");

        return line;
    }

    /**
     * Splits a normalized line into words and updates the
     * frequency map.
     *
     * @param line normalized text line
     * @param frequencies map storing the word frequency count
     */
    private void processWords(String line, Map<String, Integer> frequencies) {

        String[] words = line.split("\\s+");

        for (String word : words) {

            if (word.isEmpty()) continue;

            frequencies.merge(word, 1, Integer::sum);
        }
    }
}