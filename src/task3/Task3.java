package task3;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        // Task 3.1
        System.out.println("Task1");
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        // Task 3.2
        System.out.println("Task2");
        List<Entry<String, Integer>> products = new ArrayList<>();
        products.add(new Entry<>("Laptop", 124200));
        products.add(new Entry<>("Phone", 51450));
        products.add(new Entry<>("Headphones", 13800));

        List<Entry<String, Integer>> newPrice = sale(products, 25);
        for (Entry<String, Integer> product : newPrice) {
            System.out.println(product.product + " - " + product.price);
        }

        // Task 3.3
        System.out.println("Task3");
        System.out.println(sucsessShoot(0, 0, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));

        // Task 3.4
        System.out.println("Task4");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));

        // Task 3.5
        System.out.println("Task5");
        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock"));
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));

        // Task 3.6
        System.out.println("Task6");
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));

        // Task 3.7
        List<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Скакалка", 550, 8));
        inventory.add(new Item("Шлем", 3750, 4));
        inventory.add(new Item("Мяч", 2900, 10));
        System.out.println(mostExpensive(inventory));

        // Task 3.8
        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));
        System.out.println(longestUnique("abcvdddzxcl"));

        // Task 3.9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        // Task 3.10
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1) );
        
        
    }   

    

    static boolean isStrangePair (String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }

        if (str1.charAt(0) == str2.charAt(str2.length() - 1) &&  str1.charAt(str1.length() - 1) == str2.charAt(0)) {
            return true;
        } else return false;
    }

    static class Entry<K, V> {
        K product;
        V price;

        Entry(K product, V price) {
            this.product = product;
            this.price = price;
        }
        @Override
        public String toString() {
            return super.toString();
        }
    }

    static List<Entry<String, Integer>> sale(List<Entry<String, Integer>> products, int n) {
        for (Entry<String, Integer> product : products) {
            int price = product.price;
            int newPrice = (int) (price * (1 - n / 100.0));
            product.price = Math.max(newPrice, 1);
        }
        return products;
    }

    static boolean sucsessShoot(int x, int y, int r, int m, int n) {
        int shotRad = (int) Math.sqrt((m - x ) * (m - x)) + (int) Math.sqrt((n - y  ) * (n - y));
        if (shotRad <= r) {
            return true;
        } else return false;
    }

    static boolean parityAnalysis(int number) {
        int tmp = number;
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 1; tmp > 0; i++) {
            arr[i] = (tmp % 10);
            tmp /= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 0 && number % 2 == 0) {
            return true;
        } else if (sum % 2 != 0 && number % 2 != 0) {
            return true;
        } else return false;
    };

    static String rps(String player1, String player2) {
        String[] players = {player1.toLowerCase(), player2.toLowerCase()};
        String winCondition = "";

        int rockCount = 0, scissorsCount = 0, paperCount = 0;

        for (String player : players) {
            if (player.equals("rock")) {
                rockCount++;
            } else if (player.equals("scissors")) {
                scissorsCount++;
            } else if (player.equals("paper")) {
                paperCount++;
            }
        }

        if ((rockCount == 1 && scissorsCount == 1 && paperCount == 1) 
            ||(rockCount == 2 || scissorsCount == 2 || paperCount == 2)){
            return "Ничья";
        } else {
            if (rockCount > 0 && scissorsCount > 0) {
                winCondition = "rock";
            } else if (rockCount > 0 && paperCount > 0) {
                winCondition = "paper";
            } else if (scissorsCount > 0 && paperCount > 0) {
                winCondition = "scissors";
            }
            for (int i = 0; i < players.length; i++) {
                if (players[i].equals(winCondition)) {
                    return "Игрок " + (i + 1) + " победил";
                }
            }
        }
        return "Ничья";
    }

    static int bugger(int number) {
        if (number < 10) return 0;
        
        int product = 1;
        while (number > 0) {
            product *= (number % 10);
            number /= 10;
        }
        
        return 1 + bugger(product);
    }

    static class Item {
        String name;
        Integer cost; 
        Integer quantity;


        Item(String name, Integer cost, Integer quantity) {
            this.name = name;
            this.cost = cost;
            this.quantity = quantity;
        }
    }

    static String mostExpensive(List<Item> inventory) {
        int maxPrice = 0;
        String mostValuableItem = ""; 
        for (Item item : inventory) {
            if (item.cost * item.quantity > maxPrice) {
                maxPrice = item.cost * item.quantity;
                mostValuableItem = item.name;
            }
        }
        return mostValuableItem;
    }
    
    static String longestUnique(String str) {
        StringBuilder longestSubStr = new StringBuilder();
        StringBuilder subStr = new StringBuilder();
        for (int i = 0;  i < str.length() ; i++) {
            boolean availability = false;
            for (int j = 0; j < subStr.length(); j++) {
                if (subStr.isEmpty()) break;
                else {
                    if (subStr.charAt(j) == str.charAt(i)) {
                        availability = true;
                        break;
                    }
                }
            }
            if (!availability) {
                subStr.append(str.charAt(i));
            } else {
                if (longestSubStr.isEmpty() || subStr.length() > longestSubStr.length()) {
                    longestSubStr = subStr;
                }
                subStr = new StringBuilder();
            }
        }

        if (longestSubStr.length() < subStr.length()) {
            longestSubStr = new StringBuilder(subStr);
        }

        return longestSubStr.toString();
    } 

    static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int min1Brick = Math.min(a, b);
        int min2Brick = Math.min(b, c);
        return ((min1Brick <= w && min2Brick <= h) || (min1Brick <= h && min2Brick <= w));
    }
}
