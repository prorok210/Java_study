package lab5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FindWords {
    public static void main(String[] args) {
        String[] testCases = {"Hello, my name is John", "I am a student", "Необходимо написать программу", "При этом программа должна использовать регулярные выражения", ""};
        for (String text : testCases) {
            System.out.println(findWords(text, 'm'));
        }
    }


    static String findWords(String text, char letter) {
        if (!Character.isLetter(letter)) {
            return "Illegal letter format";
        }

        String formatedText = text.toLowerCase();
        letter = Character.toLowerCase(letter); 
        
        StringBuilder result = new StringBuilder();

        String regex = "\\b" + letter + "\\p{L}*\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(formatedText);
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }

        if (result.isEmpty()){
            return "No words with " + letter + " letters found";
        }

        return result.toString();
    }
    
}
