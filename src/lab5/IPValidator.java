package lab5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPValidator {
    public static void main(String[] args) {
        String[] testCases = {"111.22.32.231", ".322", "0.0.0.0", "", "333.333.333.333", "003.03.033.03"};
        for (String ip : testCases) {
            System.out.printf("%s:%b\n", ip, isValidIP(ip));
        }
    }


    static boolean isValidIP(String ip) {
        if (ip.isEmpty() || ip == null) {
            System.out.println("Ip is Empty");
            return false;
        }
        Pattern pattern = Pattern.compile("^((\\d{1,3}\\.){3}\\d{1,3})$");
        Matcher matcher = pattern.matcher(ip);
        if (!matcher.matches()) {
            return false;
        }

        String[] numbers = matcher.group().split("\\.");
        for (String number : numbers) {

            try {
                int octet = Integer.parseInt(number);
                if (octet < 0 || octet > 255){
                    System.out.printf("Invalid IP octet: %d\n", octet);
                    return false;   
                }

                if (!number.equals(String.valueOf(octet))) {
                    System.out.printf("Invalid octet with leading zeros: %s%n\n", number);
                    return false;
                }

            } catch (NumberFormatException e) {
                System.out.println(e);
                return false;
            }

        }
        return true;
    }
    
}
