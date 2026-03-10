# Word Frequency Analyzer

This small Java program reads a text file and analyzes the frequency of each word contained in the file.

The program processes the text line by line, normalizes the content (lowercase and punctuation removal), and counts how many times each word appears.  
Finally, it displays the **10 most frequent words** along with their number of occurrences.

## Program Structure

The solution is organized into two classes:

### 1. Main

This class is responsible for:

- Receiving the file name through the command line arguments.
- Creating an instance of `CsvReader`.
- Calling the method that reads the file and builds the word-frequency map.
- Ordering and printing the top 10 most frequent words.

### 2. CsvReader

This class handles all the file processing logic:

- Opens and reads the file line by line using `BufferedReader`.
- Normalizes each line by:
    - Converting text to lowercase
    - Removing punctuation characters
- Splits each line into individual words.
- Updates a `Map<String, Integer>` that stores the frequency of each word.

This separation keeps the code clean and follows the **single responsibility principle**, where one class manages execution and the other manages text processing.

## Example Output

Running the program with the provided test file produced the following result:

```
world -> 7
test -> 6
hello -> 5
is -> 4
this -> 3
simple -> 3
the -> 3
things -> 2
small -> 1
but -> 1
```

## How to Run

Compile the program and run it providing the text file as an argument:

```bash
javac Main.java CsvReader.java
java Main text.txt
```

Where `text.txt` is the file to analyze.