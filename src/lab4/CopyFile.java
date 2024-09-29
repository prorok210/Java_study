package lab4;

import java.io.FileInputStream;
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
            sourceFile = new FileInputStream(sourceFileName);
            destinationFile = new FileOutputStream(destinationFileName);

            byte[] buffer = new byte[1024];

            int bytesRead;

            while ((bytesRead = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, bytesRead);
            }

        }
        catch (IOException e) {
            System.out.println("Ошибка при открытии и чтение файлов:" + e.getMessage());
            return;
        } finally {
            try {
                if (sourceFile != null) {
                    sourceFile.close();
                }
                if (destinationFile != null) {
                    destinationFile.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файлов" + e.getMessage());
            }
        }   
    }
    
}
