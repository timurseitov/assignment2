public class MyStack<T> {
    private MyArraylist<T> arr;
    private int top = 0;
    private int capacity = 5;

    public MyStack() {
        arr = new MyArraylist<>(capacity);
    }

    public void push(T item) {
        if(top == capacity - 1) {
           capacity++;
        }
        arr.add(item);
        top++;
    }
    public boolean empty() {
        if (arr.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return arr.size();
    }

    public T peek() {
        if(empty() == false) {
            return arr.get(size() - 1);
        }
        return (T) "The Stack is empty";
    }

    public T pop() { //удаляет топовый элемент
        if(empty()) {
            return (T) "The Stack is empty";
        }
        T item = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        return item;
    }

    public void show() {
        System.out.println("Elements: ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
