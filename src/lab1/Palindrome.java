package lab1;
public class Palindrome {
    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {  
            String s = args[i];
            if (isPalindrome(s)){
                System.out.printf("%s явдяется палиндромом\n", s);
            } else System.out.printf("%s не является палиндромом\n", s);
        }
    }

    public static String reverseString(String str) {
        StringBuilder ret_string = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            ret_string.append(str.charAt(i));
        return ret_string.toString();
    }

    public static boolean isPalindrome(String str) {
        String reverse_str = reverseString(str);
        if (reverse_str.equals(str))
            return true;
        return false;
    }
}
