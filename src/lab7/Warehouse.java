package lab7;

import java.util.*;
import java.util.concurrent.*;

public class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private static final int NUM_WORKERS = 3;
    private static final Queue<Product> products = new LinkedList<>();
    private static int totalWeight = 0;
    private static final Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            products.offer(new Product(random.nextInt(50) + 10));
        }

        System.out.println("Список товаров:\n" +products);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_WORKERS);
        for (int i = 0; i < NUM_WORKERS; i++) {
            executor.submit(() -> {
                while (true) {
                    try {
                        semaphore.acquire();
                        if (products.isEmpty()) {
                            semaphore.release();
                            break;
                        }

                        Product item = products.peek();
                        if (totalWeight + item.getWeight() > MAX_WEIGHT) {
                            System.out.println("Перевезено" + totalWeight + " кг. Разгрузка...");
                            totalWeight = 0;
                            Thread.sleep(5000);
                            semaphore.release();
                        } else {
                            item = products.poll();
                            totalWeight += item.getWeight();
                            System.out.println(Thread.currentThread().getName() + " загрузил: " + item + " (Всего: " + totalWeight + " кг)");
                            semaphore.release();
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        semaphore.release();
                    }
                }
                return null;
            });
        }
        executor.shutdown();

        System.out.println("Работа окончена. Склад пуст.");
    }
}

class Product {
    private int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  String.valueOf(weight);
    }
}