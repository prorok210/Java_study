package lab6;

public class Main {
    public static void main(String[] args) {
        // Stack
        Stack<Integer> stack = new Stack<>(10); 
        stack.push(1); 
        stack.push(2); 
        stack.push(3); 
        System.out.println(stack.pop());  
        System.out.println(stack.peek()); 
        stack.push(4); 
        System.out.println(stack.pop());

        //SalesAcc
        SalesAccounting accounting = new SalesAccounting();

        accounting.add(new Product("Apple", 10.99));
        accounting.add(new Product("Banana", 5.49));
        accounting.add(new Product("Apple", 10.99));
        accounting.add(new Product("Orange", 7.99));

        accounting.displayProducts();

        System.out.println("Общая сумма продаж: " + accounting.getTotalSales());

        Product mostPopular = accounting.getMostPopularProduct();
        if (mostPopular != null) {
            System.out.println("Наиболее популярный товар: " + mostPopular);
        } else {
            System.out.println("Нет проданных товаров для анализа.");
        }
    }
}
