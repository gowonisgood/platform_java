package Java_platform.Genenric.MyArrayList;

public class MyArrayList<T> {

    // your code here
    private T[] array;
    private int index=0;

    public MyArrayList(int capacity) {

        // your code here
        array = (T[]) new Object[capacity];

    }



    public void add(T data) {

        // your code here
        array[index] = data;
        index++;

    }



    public T get(int index) {

        // your code here
        return array[index];

    }

}
