package task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        // task 4.1
        System.out.println(nonRepeat("abracadabra"));
        System.out.println(nonRepeat("abababcac"));
        // task 4.2
        System.out.println(String.join(", ", bruteForce(1, 5)));
        System.out.println(String.join(", ", bruteForce(2, 2)));
        System.out.println(String.join(", ", bruteForce(5, 3)));
        // task 4.3
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT"));
        System.out.println(Arrays.toString(decode("MTUCI","MKIIT"))); 
        // task 4.4
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        // task 4.5
        System.out.println(shortHand("abbccc"));
        System.out.println(shortHand("vvvvaajaaaaa"));
        // task 4.6
        System.out.println(convertToRome(8));
        System.out.println(convertToRome(1234));
        System.out.println(convertToRome(52));
        // task 4.7
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));
        System.out.println(uniqueSubstring("12223234333"));
        // task 4.8
        System.out.println(Arrays.toString(labirint(new int[][]{
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        })));

        System.out.println(Arrays.toString(labirint(new int[][]{
            {2, -7, 3},
            {-4, -1, 8},
            {4, 5, 9}
        })));
        // task 4.9
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); 
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); 
        // task 4.10
        System.out.println(fibString("CCCABDD"));
        System.out.println(fibString("ABC"));
    }
    
    // 1
    static String nonRepeat(String str) {
        String lowerStr = str.toLowerCase();
        StringBuilder result = new StringBuilder();
        boolean hasExcessiveChars = false; 

        for (int i = 0; i < lowerStr.length(); i++) {
            char currentChar = lowerStr.charAt(i);
            long count = lowerStr.chars().filter(ch -> ch == currentChar).count();

            if (count <= 3) {
                result.append(str.charAt(i));
            } else {
                hasExcessiveChars = true;
            }
        }

        if (hasExcessiveChars) {
            return nonRepeat(result.toString());
        }

        return result.toString();
    }

    // 2
    static String[] bruteForce(int n, int k) {
        if (k < 1 || n < 1 || n > k) {
            return new String[0];
        }

        int[] alphabet = new int[k];
        for (int i = 0; i < k; i++) {
            alphabet[i] = i;
        }

        List<String> result = new ArrayList<>();
        generateCombinations("", k, n, result);

        return result.toArray(new String[0]);
    }

    static void generateCombinations(String current, int k, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (int i = 0; i < k; i++) {
            char nextChar = (char) ('0' + i); 
            if (!current.contains(String.valueOf(nextChar))) {
                generateCombinations(current + nextChar, k, n, result); 
            }
        }
    }

    // 3
    static String encode(int[] numbers, String key) {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            char encryptedChar = (char) (numbers[i] ^ key.charAt(i % key.length()));
            encoded.append(encryptedChar);
        }

        return encoded.toString();
    }

    static int[] decode(String encoded, String key) {
        int[] decodedNumbers = new int[encoded.length()];

        for (int i = 0; i < encoded.length(); i++) {
            decodedNumbers[i] = encoded.charAt(i) ^ key.charAt(i % key.length());
        }

        return decodedNumbers;
    }

    //4 
    public static List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder currentCluster = new StringBuilder();

        for (char ch : s.toCharArray()) {
            currentCluster.append(ch); 

            if (ch == '(') {
                balance++; 
            } else if (ch == ')') {
                balance--; 
            }

            if (balance == 0) {
                result.add(currentCluster.toString()); 
                currentCluster.setLength(0);
            }
        }

        return result;
    }

    //5
    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append("*").append(count); 
                }
                count = 1;
            }
        }

        return result.toString();
    }

    //6
    public static String convertToRome(int num) {
        if (num <= 0 || num > 1502) {
            throw new IllegalArgumentException("Number must be between 1 and 1502");
        }

        String[] romanNumerals = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    //7
    public static String uniqueSubstring(String str) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        char maxChar = '\0';
        int maxCount = 0;

        for (char c : countMap.keySet()) {
            int count = countMap.get(c);
            if (count > maxCount || (count == maxCount && (maxChar == '\0' || str.indexOf(c) < str.indexOf(maxChar)))) {
                maxChar = c;
                maxCount = count;
            }
        }

        int index = str.indexOf(maxChar);

        if (index % 2 == 0) {
            return "чет";
        } else {
            return "нечет";
        }
    }

    //8
    public static String[] labirint(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        String[][] path = new String[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[n - 1][n - 1] = matrix[n - 1][n - 1];
        path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0) continue;

                if (i < n - 1 && dp[i + 1][j] != Integer.MAX_VALUE) { 
                    int newCost = dp[i + 1][j] + matrix[i][j];
                    if (newCost < dp[i][j]) {
                        dp[i][j] = newCost;
                        path[i][j] = path[i + 1][j] + "-" + matrix[i][j];
                    }
                }

                if (j < n - 1 && dp[i][j + 1] != Integer.MAX_VALUE) { 
                    int newCost = dp[i][j + 1] + matrix[i][j];
                    if (newCost < dp[i][j]) {
                        dp[i][j] = newCost;
                        path[i][j] = path[i][j + 1] + "-" + matrix[i][j];
                    }
                }
            }
        }

        if (dp[0][0] == Integer.MAX_VALUE) {
            return new String[]{"Прохода нет"};
        } else {
            return new String[]{path[0][0], String.valueOf(dp[0][0])};
        }
    }

    //9
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int numA = Integer.parseInt(a.replaceAll("[^0-9]", ""));
                int numB = Integer.parseInt(b.replaceAll("[^0-9]", ""));
                return Integer.compare(numA, numB);
            }
        });

        return String.join(" ", words).replaceAll("[0-9]", "").trim();
    }

    //10
    public static boolean fibString(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
    
        boolean hasRepeatingCharacters = false;
    
        for (int count : charCount.values()) {
            if (count > 1) {
                hasRepeatingCharacters = true;
            }
            if (!isFibonacci(count)) {
                return false;
            }
        }
    
        return hasRepeatingCharacters;
    }
    
    public static boolean isFibonacci(int number) {
        if (number < 0) return false;
    
        int a = 0;
        int b = 1;
    
        while (b < number) {
            int temp = b;
            b = a + b;
            a = temp;
        }
    
        return b == number || number == 0;
    }
}
