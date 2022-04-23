public class MyQueue<T> {
    private int back = 0;
    private int front = 0;
    private int capacity = 5;
    MyArraylist<T> arr = new MyArraylist<>(capacity);

    public void enqueue(T item) {
        if (back == capacity) {
            capacity++;
        }
        arr.add(item);
        back++;
    }

    public T dequeue() {
        if(empty() || size() == 0) {
            return (T) "The Stack is empty";
        }
        front++;
        back--;
        arr.length--;
        return arr.get(front - 1);
    }

    public T peek() {
        return arr.get(front);
    }

    public int size() {
        return arr.size();
    }

    public boolean empty() {
        if(back == 0) {
            return true;
        }
        return false;
    }

    public void show() {
        System.out.println("Elements: ");
        for (int i = 0; i < size(); i++) {
            System.out.print(arr.get(front + i) + " ");
        }
    }

}
