package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FindMax {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int rows = 10; 
        int cols = 10; 
        int[][] matrix = new int[rows][cols];

        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(7777);
            }
        }
        
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int numberOfThreads = rows; 
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            int row = i;

            Callable<Integer> task = () -> {
                int localMax = Integer.MIN_VALUE;
                for (int c = 0; c < cols; c++) {
                    localMax = Math.max(localMax, matrix[row][c]);
                }
                return localMax;
            };

            results.add(executor.submit(task)); 
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> result : results) {
            globalMax = Math.max(globalMax, result.get());
        }

        executor.shutdown();

        System.out.println("Наибольший элемент в матрице: " + globalMax);
    }
}
