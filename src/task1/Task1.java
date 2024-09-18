package task1;


public class Task1 {
    public static void main(String[] args) {
        System.out.println("1 таск");
        System.out.printf("%.3f %.3f %.3f", convert(5), convert(3),convert(8));

        System.out.println("\n2 таск");
        System.out.printf("%d %d %d", fitCalc(15, 1), fitCalc(24, 2), fitCalc(41, 3));

        System.out.println("\n3 таск");
        System.out.printf("%d %d %d", containers(3, 4, 2), containers(5, 0, 2), containers(4, 1, 4));

        System.out.println("\n4 таск");
        System.out.printf("%s %s %s %s", triangleType(5, 5, 5), triangleType(5, 4, 5), triangleType(3, 4, 5), triangleType(5, 1, 1));

        System.out.println("\n5 таск");
        System.out.printf("%d %d %d", ternaryEvaluation(8, 4), ternaryEvaluation(1, 11), ternaryEvaluation(5, 9));

        System.out.println("\n6 таск");
        System.out.printf("%d %d %d", howManyItems(22, 1.4, 2), howManyItems(45, 1.8, 1.9), howManyItems(100, 2, 2));

        System.out.println("\n7 таск");
        System.out.printf("%d %d %d", factorial(3), factorial(5), factorial(7));

        System.out.println("\n8 таск");
        System.out.printf("%d %d %d", gcd(48, 18), gcd(52, 8), gcd(259, 28));

        System.out.println("\n9 таск");
        System.out.printf("%d %d %d", ticketSaler(70, 1500), ticketSaler(24, 950), ticketSaler(53, 1250));

        System.out.println("\n10 таск");
        System.out.printf("%d %d %d", tables(5, 2), tables(31, 20), tables(123, 58));
        
    }

    static double convert(double liters) {
        return 3.785411784 * liters;
    }

    static int fitCalc(int minutes, int intensity) {
        if (intensity < 1 || intensity > 3) {
            return -1;
        }
        return minutes * intensity;
    }
    

    static int containers(int boxes, int bags, int barrels) {
        final int box = 20, bag = 50, barrel = 100;
        if (boxes < 0 || bags < 0 || barrels < 0) {
            return -1;
        }
        return boxes * box + bags * bag + barrels * barrel;
    }

    static String triangleType(int X, int Y, int Z) {
        if (X <= 0 || Y <= 0 || Z <= 0) {
            return "incorrect data";
        }
        if (X + Y <= Z || X + Z <= Y || Y + Z <= X) {
            return "not a triangle";
        }
        if (X == Y && Y == Z) {
            return "isosceles";
        }
        if (X == Y || Y == Z || X == Z) {
            return "equilateral";
        }
        return "different-sided";
    }

    static int ternaryEvaluation(int a, int  b) {
        return a > b ? a : b;
    }

    static int howManyItems(double length, double width, double height) {
        double itemArea = width * height * 2;
        return (int) (length / itemArea);
    }

    static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int gcd(int a, int b) {
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    static int ticketSaler(int quantity, int price) {
        double resPrice = (1 - 0.28 ) * (double)price;
        return quantity * (int)resPrice;
    }
    
    static int tables(int chairs, int tables) {
        int resTebles = (chairs + 1) / 2;
        return resTebles > tables ? resTebles - tables : 0;
    }
}

