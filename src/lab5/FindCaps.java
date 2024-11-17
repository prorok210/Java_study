package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCaps {
    public static void main(String[] args) {
        String[] testCases = {"FgFgFgFgdasdasdasDFFDDSADDfdfdfdfDFf", "dasasdasdas", "dD", "Необходимо нАписать программу, которая будет находить все случаи в \r\n" + //
                        "тексте, когда сразу после строчной буквы идет заглавная, без какого-либо \r\n" + //
                        "символа между ними, и выдЕлять их знаками ! с двух сторон. "};
        for (String text : testCases) {
                System.out.println(findAndMarkCaps(text));
        }
    }

    public static String findAndMarkCaps(String text) {

        Pattern pattern = Pattern.compile("([a-zа-я])([A-ZА-Я])");
        Matcher matcher = pattern.matcher(text);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, "!" + matcher.group(1) + matcher.group(2) + "!");
        }
        matcher.appendTail(result);
        return result.toString();
    }
}