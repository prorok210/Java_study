package lab4;

import java.util.Scanner;
import java.util.InputMismatchException;


public class IntInput {
    public static void main(String[] args) throws CustomInputMismatchException {
        Scanner scanner = new Scanner(System.in);
        try {
            int number = scanner.nextInt();
            System.out.println("Number: " + number);
        } catch (InputMismatchException  e) {
            throw new CustomInputMismatchException("Input is not a number");
        } finally {
            scanner.close();
        }
    }

    public static class CustomInputMismatchException extends Exception {
        public CustomInputMismatchException(String message) {
            super(message);
        }
    }

}

