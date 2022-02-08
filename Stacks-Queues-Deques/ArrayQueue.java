public class ArrayQueue<E> implements Queue<E> {
    // instance variables
    private static final int CAPACITY = 1000;
    private E[] data; // generic array used for storage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements

    // constructors
    public ArrayQueue() {
        this(CAPACITY);
    } // constructs queue with default capacity

    public ArrayQueue(int capacity) { // constructs queue with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // methods
    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return (sz == 0);
    }

    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length; // use modular arithmetic
        data[avail] = e;
        sz++;
    }

    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = data[f];
        data[f] = null; // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}