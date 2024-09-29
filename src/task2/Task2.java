package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(duplicateChars("Barack", "Obama"));
        System.out.println("Task 2");
        System.out.println(dividedByThree(new int[]{3, 12, 7, 81, 52}));
        System.out.println("Task 3");
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println("Task 4");
        System.out.println(Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5}))); 
        System.out.println(Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));
        System.out.println("Task 5");
        System.out.println(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5}));
        System.out.println("Task 6");
        System.out.println(camelToSnake("helloWorld"));
        System.out.println("Task 7");
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));
        System.out.println("Task 8");
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        System.out.println("Task 9");
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        System.out.println("Task 10");
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }

    static String duplicateChars(String string1, String string2) {
        StringBuilder res = new StringBuilder();
        String str1 = string1.toLowerCase();
        String str2 = string2.toLowerCase();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            Boolean isDuplicate = false;
            for (int j = 0; j < str2.length(); j++) {
                if (c == str2.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                res.append(c);
            }
        }
        return res.toString();
    }

    static int dividedByThree(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                continue;
            }
            if (arr[i] % 3 == 0) {
                res ++;
            }
        }
        return res;
    }

    static String getInitials(String fullString) {
        StringBuilder res = new StringBuilder();
        String[] words = fullString.split(" ");
        if ((words.length == 0) || (words.length > 3)) {
            return "Error";
        }
        String firstName = "";
        String initials = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                words[i] = words[i].trim();
                firstName = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            } else {
                words[i] = words[i].trim();
                initials += words[i].substring(0, 1).toUpperCase() + ".";
            }
        }
        res.append(initials + firstName);
        return res.toString();
    }

    static double[] normalizator(double[] arr) {
        double[] res = new double[arr.length];
        double min = 0;
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                min = arr[i];
                max = arr[i];
            } else {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (max == min) {
                res[i] = 0;
                continue;
            }
            res[i] = (arr[i] - min)/(max- min);
        }
        return res;
    }

    static Collection<Integer> compressedNums(double[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((int)arr[i] == 0)
                continue;
            else {
                res.add((int)arr[i]);
            }
            
        }
        return res;
    }

    static String camelToSnake(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                res.append("_");
                res.append(Character.toLowerCase(c));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    static int secondBiggest(int[] arr) {
        int max = 0, secondMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                max = arr[i];
            } else {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                secondMax = arr[i];
            } else {
                if ((arr[i] > secondMax) && (arr[i] < max)) {
                    secondMax = arr[i];
                }
            }
        }
        return secondMax;
    }

    static String localReverse(String str, char c) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        String[] parts = str.split(String.valueOf(c));
        for (int i = 0; i < parts.length; i++) {
            if (i == 0) {
                res.append(parts[i]);
                res.append(c);
                continue;
            }

            temp.append(parts[i]);
            if (i % 2 == 0) 
                res.append(temp);
            else
                res.append(temp.reverse());
            temp.setLength(0);
            res.append(c);
        }
        return res.toString();
    }

    static int equal(int a, int b, int c) {
        if ((a == b) && (b == c)) {
            return 3;
        } else if ((a == b) || (b == c) || (a == c)) {
            return 2;
        } else {
           return 0;
        }
    }

    static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        StringBuilder res1 = new StringBuilder();
        StringBuilder res2 = new StringBuilder();
        char[] arr1 = new char[str1.length()];
        char[] arr2 = new char[str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            if ((str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z') || (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z')) {
                res1.append(str1.charAt(i));
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if ((str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') || (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z')) {
                res2.append(str2.charAt(i));
            }
        }
        arr1 = res1.toString().toCharArray();
        arr2 = res2.toString().toCharArray();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            return true;
        } else {
            return false;
        }

    }
}
