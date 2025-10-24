package src.main.java.bench;

public class QueueRA<E> {
    private E[] queue;
    private int size;

    public QueueRA() {
        this.queue = null;
        this.size = 0;
    }

    public void enqueue(E element) {
        size++;
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) { // copy array into new array
            temp[i] = queue[i];
        }
        temp[size - 1] = element;
        queue = temp;
    }

    public E dequeue() {
        size--;
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) { // copy array into new array
            temp[i] = queue[i + 1];
        }
        E val = queue[0];
        queue = temp;
        return val;
    }

    public boolean isEmpty() {
        return queue.length == 0;
    }

    public int size() {
        return size;
    }
}
