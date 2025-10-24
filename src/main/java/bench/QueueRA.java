package src.main.java.bench;

public class QueueRA<E> {
    private E[] queue;
    private int blockSize;
    private int currentSize;
    private int bufferSize;
    private int startBuffer;

    public QueueRA(int buffer) {
        if (buffer < 1)
            throw new IllegalArgumentException("Buffer size has to be 1 or greater");
        this.bufferSize = buffer;
        this.blockSize = buffer;
        this.currentSize = 0;
        this.startBuffer = 0;
        this.queue = (E[]) new Object[blockSize];
    }

    public QueueRA() {
        this(10);
    }

    public void enqueue(E element) {
        if ((this.currentSize + this.startBuffer) == this.blockSize) {
            E[] temp = (E[]) new Object[this.blockSize + this.bufferSize];
            for (int i = 0; i < this.blockSize; i++) {
                temp[i] = this.queue[i];
            }
            this.queue = temp;
            this.blockSize += this.bufferSize;
        }
        this.queue[this.currentSize + this.startBuffer] = element;
        this.currentSize++;
    }

    public E dequeue() {
        if (currentSize == 0) {
            return null;
        } else {
            this.currentSize--;
            E val = this.queue[0];
            this.startBuffer++;
            if (this.startBuffer >= this.bufferSize) {
                this.blockSize -= this.bufferSize;
                E[] temp = (E[]) new Object[this.blockSize];
                for (int i = 0; i < (this.blockSize); i++) {
                    temp[i] = this.queue[i + this.bufferSize];
                }
                this.startBuffer -= this.bufferSize;
                this.queue = temp;
            }
            return val;
        }
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int size() {
        return this.currentSize;
    }
}
