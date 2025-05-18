//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Main {
    private static boolean startsAndEndsWithVowel(String word) {
        String vowels = "aeiouAEIOU";
        if (word.length() == 0) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return vowels.indexOf(first) >= 0 && vowels.indexOf(last) >= 0;
    }
    public static void main(String[] args) {
        String fileName = "src/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("^[^a-zA-Z]+|[^a-zA-Z]+$", "");
                    if (startsAndEndsWithVowel(word)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}