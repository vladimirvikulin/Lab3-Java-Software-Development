import java.util.List;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int studentBook = 1106; 
            int C3 = studentBook % 3;
            int C17 = studentBook % 17;
            System.out.println("C3:" + C3); // 2 => String
            System.out.println("C17:" + C17); // 1 => Вивести всі речення заданого тексту в порядку зростання кількості слів у них
            System.out.println("Введiть текст:");
            String inputText = scanner.nextLine();
            TextHandler textHandler = new TextHandler();
            if (!textHandler.isValidData(inputText)) return;
            List<String> sentences = textHandler.splitTextIntoSentences(inputText);
            sentences.sort((s1, s2) -> textHandler.countWords(s1) - textHandler.countWords(s2));

            System.out.println("\n" + "Речення в порядку зростання кiлькостi слiв:");
            for (String sentence : sentences) {
                System.out.println(sentence);
            }
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
