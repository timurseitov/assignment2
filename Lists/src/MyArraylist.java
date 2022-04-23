public class MyArraylist<T> implements MyList<T>{
    private Object[] arr;
    public int length = 0;
    private int capacity = 3;

    public MyArraylist(int capacity) {
        arr = new Object[this.capacity];
    }

    public void add(T item) {
        if (length == capacity) {
            increaseCapacity();
        }
        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if (length == capacity) increaseCapacity();

        Object[] arr1 = new Object[arr.length - index + 1];  //создаем новый массив
        for (int i = index; i < arr.length - index + 1; i++) {   //в который будем записывать значения
            arr1[i] = arr[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println();
        arr[index] = item;
        for (int i = index + 1; i < arr1.length + (arr1.length - index); i++) {
            arr[i] = arr1[i - 1];                         //приравниваем значения первого массива после индекса второму
        }

    }

    @Override
    public boolean remove(T item) {   //removes the first occurrence of the specified element from the list. Returns true is any element was removed from the list, else false.
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(item)) {
                index = i;
            }
        }

        if(index == -1) return false;
        else {
            for (int i = index; i < arr.length; i++) {
                arr[i] = arr[i + 1];
            }
            return true;
        }
    }

    @Override
    public T remove(int index) {
        for (int i = index; i < length; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        length--;
        return (T) arr;
    }

    @Override
    public void clear() {
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++) {
            arr[i] = old[i];
        }
    }

    public T get(int index) {
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for(;i <arr.length; i++){
            if(arr[i].equals(o)){
                break;
            }
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = this.length - 1; i >= 0; i--) {
            if (o.equals(this.arr[i])) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void sort() {
//      ArrayList<T> newArrayList = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            newArrayList.add((T) arr[i]);
//        }                                                 i tried.
//        Collections.sort(newArrayList<T>);
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = newArrayList.get(i);
//        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

}
