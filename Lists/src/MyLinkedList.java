public class MyLinkedList<T> implements MyList<T>{
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for(MyNode<T> i = head; i != null; i = i.next) {
            if (o.equals(i.data)) {
                return true;
            }
        }

        return false;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if(index == 0) {
            MyNode<T> newNode = new MyNode<>(item); // Create a new node
            newNode.next = head;                    // link the new node with the head
            head = newNode;                         // head points to the new node
            length++;                               // Increase list size

            if (tail == null)   // if the new node is the only node in list
                tail = head;

        }
        else if (index >= length) {
            MyNode<T> newNode = new MyNode<>(item);

            if(tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;    // Link the new with the last node
                tail = tail.next;      // tail now points to the last node
            }
            length++;
        }

        else {
            MyLinkedList.MyNode<T> current = head;

            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            MyNode<T> temp = current.next;
            current.next = new MyNode<T>(item);
            (current.next).next = temp;
            length++;
        }
    }

    @Override
    public boolean remove(T item) {
        if (head == null) {
            return false;
        } else {
            for(MyNode<T> i = head; i != null; i = i.next) {
                if (item.equals(i.data)) {
                    i.data = i.next.data;
                    i.next = i.next.next;
                }
            }

            length--;
            return true;
        }
    }

    @Override
    public T remove(int index) {
        if (head == null) {
            return (T) null;
        } else if (index == 0) {
            return (T) head.next;
        } else {
            MyNode<T> current = head;

            for(int counter = 0; counter < index - 1; counter++) {
                current = current.next;
            }

            current.next = current.next.next;
            length--;
            return (T) head;
        }
    }

    @Override
    public void clear() {
        length = 0;
    }

    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        }
        MyNode<T> temp = head;

        while(index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int counter = 0;

        for(MyNode<T> i = this.head; i != null; i = i.next) {
            if (o.equals(i.data)) {
                return counter;
            }

            counter++;
        }

        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode<T> index = head;
        int counter = 0;
        int lastIndex = -1;
        for (MyNode<T> i = head; i != null; i = i.next) {
            counter++;
            if (o.equals(i.data)) {
                lastIndex = counter;
            }
        }
        return lastIndex - 1;
    }

    @Override
    public void sort() {
        //sorry(
    }


}