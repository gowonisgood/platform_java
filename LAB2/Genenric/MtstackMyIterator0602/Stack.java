package Java_platform.Genenric.MtstackMyIterator0602;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Integer;
//import java.util.Stack;

public class Stack<T> {
    private T[] stackArray;
    private int size;
    private static final int INITIAL_CAPACITY = 5;
    // ...

    public Stack() {
        size = 0;
        stackArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void push(T element) {
        if(size==stackArray.length){
            resizeArray();
        }
        stackArray[size++] = element;
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackArray[--size];
    }

    public boolean isEmpty() {
        return (size < 0);
    }

    public void pushAll(Iterable<? extends T>elements){
        for(T element: elements){
            push(element);
        }
    }

    public void resizeArray(){
        T[] newArray = (T[])new Object[size*2];
        System.arraycopy(stackArray,0,newArray,0,stackArray.length);
        stackArray = newArray;
        System.out.printf("Resizing stack with %d elements\n",stackArray.length);
        //size*=2;
    }

    public int size(){
        return size;
    }


    private class MyIterator implements Iterator<T> {
        private int currentIndex = size - 1;

        @Override
        public boolean hasNext() {
            // Implement your code
            return currentIndex>=0;
        }

        @Override
        public T next() {
            // Implement your code
            return stackArray[currentIndex--];
        }
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }
}