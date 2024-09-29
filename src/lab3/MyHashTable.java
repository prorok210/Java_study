package lab3;

import java.util.LinkedList;
import java.util.AbstractList;

public class MyHashTable extends AbstractList<Object> {
    private int size = 128;
    private LinkedList<Entry>[] table;
    private int count = 0;

    private class Entry {
        String key;
        String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    public MyHashTable() {
        table = (LinkedList<Entry>[]) new LinkedList[size];
        for (int i = 0; i < size; i++)
            table[i] = new LinkedList<Entry>();
    }

    private int hash(String key, int size) {
        int hash = 17;
        for (int i = 0; i < key.length(); i++) 
            hash = hash * 113 + key.charAt(i);
        if (size == 0) 
            setSize(128);
    
        return Math.abs(hash) % size;
    }

    @Override
    public Object get(int index) {
       return table[index];
    }

    public String get(String key) {
        if (key == null)
            return null;

        int index = hash(key, size);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException();

        this.size = size;
        if (table.length < size) 
            resize(size);
    }

    private void resize(int newSize) {
        LinkedList<Entry>[] oldTable = table;
        table = (LinkedList<Entry>[]) new LinkedList[newSize];
        for (int i = 0; i < newSize; i++) 
            table[i] = new LinkedList<Entry>();

        for (int i = 0; i < size; i++) {
            for (Entry entry : oldTable[i]) {
                int index = hash(entry.key, newSize);
                table[index].addLast(entry);
            }
        }
        setSize(newSize);
    }

    public int getCount() {
        return count;
    }

    public void put(String key, String value) {
        if (key == null || key.equals("") )
            throw new NullPointerException();

        count++;
        if (count > size)
            resize(size * 2);

        int index = hash(key, size);
        table[index].addLast(new Entry(key, value));        
    }

    public String remove(String key) {
        if (key == null) 
            return null;

        int index = hash(key, size);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                table[index].remove(entry);
                count--;
                return entry.value;
            }
        }
        count--;
        if (count < size / 4)
            resize(size / 2);
        return null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            table[i].clear();
        }
        resize(128);
        count = 0;
    }

    public boolean contains(String key) {
        if (key == null)
            return false;

        int index = hash(key, size);
        for (Entry entry : table[index]) {
            if (entry.key.equals(key))
                return true;
        }
        return false;
    }

    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (Entry entry : table[i]) {
                System.out.print(entry.toString());
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            if (table[i].size() > 0) {
                System.out.print(i + ": ");
                for (Entry entry : table[i]) {
                    System.out.print(entry.toString());
                    System.out.print(", ");
                }
                System.out.println();
            }
        }
    }
}