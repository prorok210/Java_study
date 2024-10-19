package lab5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPValidator {
    public static void main(String[] args) {
        String[] testCases = {"111.22.32.231", ".322", "0.0.0.0", "", "333.333.333.333", null};
        for (String ip : testCases) {
            try {
                System.out.println(isValidIP(ip));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    static boolean isValidIP(String ip) {
        if (ip == null) {
            throw new IllegalArgumentException("Null pointer exception");
        }
        Pattern pattern = Pattern.compile("^((\\d{1,3}.){3}\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        if (!matcher.matches()) {
            return false;
        }

        String[] numbers = matcher.group().split("\\.");
        for (String number : numbers) {
            int octet = Integer.parseInt(number);
            if (octet < 0 || octet > 255) {
                return false;
            }
        }
        return true;
    }
    
}
