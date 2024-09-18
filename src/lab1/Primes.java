package lab1;
import java.util.Scanner;


public class Primes {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = input.nextInt();

        for (int i = 0; i < number; i++ ){
            if (isPrime(i))
                System.out.println(i);
        }

        input.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) 
            return false;     
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 5; i <= sqrtN; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
