package lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }
}

public class SalesAccounting {
    private ArrayList<Product> salesProducts;  
    private double totalSales; 


    public SalesAccounting() {
        salesProducts = new ArrayList<>();  
        totalSales = 0.0;  
    }

    public void add(Product product) {
        salesProducts.add(product);
        totalSales += product.getPrice(); 
    }

    public void displayProducts() {
        if (salesProducts.isEmpty()) {
            System.out.println("Нет проданных товаров.");
        } else {
            System.out.println("Список проданных товаров:");
            for (Product product : salesProducts) {
                System.out.println(product);
            }
        }
    }

    public double getTotalSales() {
        return totalSales;
    }

    public Product getMostPopularProduct() {
        if (salesProducts.isEmpty()) {
            return null;
        }

        Map<Product, Integer> productFrequency = new HashMap<>();  
        for (Product product : salesProducts) {
            productFrequency.put(product, productFrequency.getOrDefault(product, 0) + 1);
        }

        Product mostPopularProduct = null;
        int maxCount = 0;

        for (Map.Entry<Product, Integer> entry : productFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopularProduct = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostPopularProduct;  
    }
}
