package lab7;

import java.util.*;
import java.util.concurrent.*;

public class ArrSum {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int numOfThreads = 5;
        ExecutorService executor = Executors.newFixedThreadPool(numOfThreads);

        int chunkSize = (int)Math.ceil((double)arr.length / numOfThreads);
        List<Future<Integer>> results = new ArrayList<>();

        for (int i = 0; i < numOfThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, arr.length);

            int[] chunk = Arrays.copyOfRange(arr, start, end); 
            Callable<Integer> task = () -> {
                int sum = 0;
                for (int num : chunk) {
                    sum += num; 
                }
                return sum;
            };

            results.add(executor.submit(task));
        }

        int totalSum = 0;
        for (Future<Integer> result : results) {
            totalSum += result.get(); 
        }

        executor.shutdown();

        System.out.println("Сумма всех элементов массива: " + totalSum);
    }
}
