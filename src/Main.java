import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("The command needs an Argument");
            return;
        }

        String filename = args[0];

        CsvReader csvReader = new CsvReader(filename);
        Map<String, Integer> frequency = csvReader.read();

        printTopFrequencies(frequency);
    }

    private static void printTopFrequencies(Map<String, Integer> frequency){
        frequency.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(10)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );
    }
}