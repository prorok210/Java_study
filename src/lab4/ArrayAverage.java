package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = null;
        try {
            System.out.println(average(arr));
        } catch (IllegalArgumentException e1) {
            System.out.println("Error: " + e1.getMessage());
        } catch (IndexOutOfBoundsException e2) {
            System.out.println("Error: " + e2.getMessage());
        } catch (ArithmeticException e3) {
            System.out.println("Error: " + e3.getMessage());
        } catch (NullPointerException e4) {
            System.out.println("Error: Array is null");
        }
    }
    
    public static double average(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (arr.length == 0) {
            throw new ArithmeticException("Cannot calculate average of an empty array");
        }
    
        int sum = 0;
        for (int i = 0; i < arr.length + 1 ; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }
}
