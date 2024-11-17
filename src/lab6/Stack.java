package lab6;

public class Stack <T> {
    private T[] data;
    private int size , capacity;


    public Stack(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public void push(T element) { 
        if (size == capacity) {
            this.resize(capacity * 2);
        }

        data[size] = element;
        this.size++;
    } 

    public T pop() { 
        if (size == 0) return null;
        T res =  data[size - 1];
        data[size - 1] = null;
        this.size--;
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return res;
    } 

    public T peek() { 
        if (size == 0) return null;
        return data[size - 1];
    } 

    private void resize(int newCap) {
        T[] tmp = (T[]) new Object[newCap];
        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }
        this.data = tmp;
        this.capacity = newCap;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
