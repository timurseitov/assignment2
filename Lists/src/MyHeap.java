import java.util.Comparator;

public class MyHeap<T extends Comparable<T>> {
    private int capacity;
    private int size;
    public Object[] arr;

    public MyHeap() {
        capacity = 5;
        size = 0;
        arr = new Object[capacity];

    }

    public void add(T item) {
        if (size == capacity) {
            increaseCapacity();
        }
        arr[size] = item;
        size++;
        heapify(size);
    }

    private void heapify(int par) {
        int left, right;
        int min;

        left = par * 2 + 1;
        right = par * 2 + 2;

        if (left < size && (Integer) arr[left] < (Integer) arr[par])
            min = left;
        else
            min = par;

        if (right < size && (Integer) arr[right] < (Integer) arr[min])
            min = right;

        if (min != par) {
            int temp = (Integer) arr[par];
            arr[par] = arr[min];
            arr[min] = temp;
            heapify(min);
        }
    }

//    public T removeRoot() {
//
//    }
//
//    public boolean remove(T item) {
//
//    }



//    public int length() {
//        return size;
//    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public void show() {
        System.out.println("Elements: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
