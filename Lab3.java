import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        try {
            int studentBook = 1106; 
            int C3 = studentBook % 3;
            int C17 = studentBook % 17;
            System.out.println("C3:" + C3); // 2 => String
            System.out.println("C17:" + C17); // 1 => Вивести всі речення заданого тексту в порядку зростання кількості слів у них
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введiть текст:");
            String inputText = scanner.nextLine();
            scanner.close();
            if (!isValidData(inputText)) return;
            List<String> sentences = splitTextIntoSentences(inputText);
            sentences.sort((s1, s2) -> countWords(s1) - countWords(s2));

            System.out.println("\n" + "Речення в порядку зростання кiлькостi слiв:");
            for (String sentence : sentences) {
                System.out.println(sentence);
            }
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static List<String> splitTextIntoSentences(String text) {
        List<String> sentences = new ArrayList<>();
        String[] parts = text.split("[.!?]");
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                sentences.add(part.trim());
            }
        }
        return sentences;
    }

    public static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    public static boolean isValidData(String input) {
        if (input.isEmpty()) {
               System.out.println("Текст не було введено");
               return false;
       } else if (!input.matches("^[a-zA-Z.,!?;\\s]+$")) {
               System.out.println("Введено неприпустимi символи. Будь ласка, введiть тiльки лiтери.");
               return false;
       } else {
           return true;
       }
   }
}