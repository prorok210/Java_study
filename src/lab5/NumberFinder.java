package lab5;

import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {

        String text = "The price of the product is $19,99. The price of the item is $5.99. 2312312312.321312312.9 dasdasdasd 21312dasda22312312 dasd 213123 312312 1321312qwe312312312a2131231"; 
        Pattern pattern = Pattern.compile("(\\d+[.,]\\d+)|(\\d+(?![.,]))");
        Pattern errPattern = Pattern.compile(("\\d+[.,]\\d+[.,]\\d+"));
        Matcher matcher = pattern.matcher(text);
        Matcher errMatcher = errPattern.matcher(text);
        while (errMatcher.find()) {
            System.out.println("Error: Incorrect number format " + errMatcher.group());
        }
        while (matcher.find()) {
                System.out.println(matcher.group());
        }
    }
}
