package lab7;

import java.util.*;
import java.util.concurrent.*;

public class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> products = new LinkedList<>(); 

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            products.offer(random.nextInt(100));
        }

        System.out.println(products);

        Semaphore semaphore = new Semaphore(NUM_WORKERS);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);

        List<Callable<Void>> workers = new ArrayList<>();
        for (int i = 0; i < NUM_WORKERS; i++) {
            workers.add(() -> {
                while (true) {
                    List<Integer> load = new ArrayList<>(); 
                    int currentWeight = 0;

                    semaphore.acquire();
                    try {
                        synchronized (products) {
                            while (!products.isEmpty() && currentWeight + products.peek() <= MAX_WEIGHT) {
                                int item = products.poll();
                                load.add(item);
                                currentWeight += item;
                            }
                        }
                    } finally {
                        semaphore.release();
                    }
                
                    if (load.isEmpty()) {
                        break;
                    }
            
                    System.out.println(Thread.currentThread().getName() + " перевозит груз: " + load + " (общий вес: " + currentWeight + " кг)");
                
                    Thread.sleep(2000);
                }
                return null;
            });
        }
        executor.invokeAll(workers);
        executor.shutdown();

        System.out.println("Работа окончена. Склад пуст.");
    }
}