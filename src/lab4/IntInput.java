package lab4;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;


public class IntInput {
    public static void main(String[] args) throws CustomInputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");

        try {
            int number = readInteger(scanner);
            System.out.println("Number: " + number);
        } catch (CustomInputMismatchException  e) {
            System.out.println("Ошибка: " + e.getMessage());
            logExceptionToFile(e);
        } finally {
            scanner.close();
        }
    }

    public static int readInteger(Scanner scanner) throws CustomInputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new CustomInputMismatchException("Введенное значение не является целым числом.");
        }
    }

    public static void logExceptionToFile(Exception e) {
        FileOutputStream logFile = null;
        try {
            logFile = new FileOutputStream("log.txt", true);
            LocalDateTime now = LocalDateTime.now();
            String timestamp = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String message = timestamp + ":" + e.getClass() +e.getMessage() + "\n";
            logFile.write(message.getBytes());
        } catch (Exception ex) {
            System.out.println("Ошибка при открытии файла: " + ex.getMessage());
            return;
        } finally {
            if (logFile != null) {
                try {
                    logFile.close();
                } catch (Exception ex) {
                    System.out.println("Ошибка при закрытии файла: " + ex.getMessage());
                }
            }
        }
    }
}

