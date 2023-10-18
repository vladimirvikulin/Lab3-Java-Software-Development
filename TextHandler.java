import java.util.ArrayList;
import java.util.List;

public class TextHandler {
    public List<String> splitTextIntoSentences(String text) {
        List<String> sentences = new ArrayList<>();
        String[] parts = text.split("[.!?]");
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                sentences.add(part.trim());
            }
        }
        return sentences;
    }

    public int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    public boolean isValidData(String input) {
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