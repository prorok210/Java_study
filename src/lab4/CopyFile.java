package lab4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

    public static void main(String[] args) {
        copy("source.txt", "dist.txt");

    }

    public static void copy(String sourceFileName, String destinationFileName) {
    FileInputStream sourceFile = null;
    FileOutputStream destinationFile = null;

    try {
        try {
            sourceFile = new FileInputStream(sourceFileName);
            destinationFile = new FileOutputStream(destinationFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при открытии файлов: " + e.getMessage());
            return;
        }

        byte[] buffer = new byte[1024];
        int bytesRead;

        try {
            while ((bytesRead = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файлов: " + e.getMessage());
            return;
        }

    } finally {
        if (sourceFile != null) {
            try {
                sourceFile.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии исходного файла: " + e.getMessage());
            }
        }
        if (destinationFile != null) {
            try {
                destinationFile.close();
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла назначения: " + e.getMessage());
            }
        }
    }
}
    
}
