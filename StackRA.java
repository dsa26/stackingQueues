public class StackRA<E> {
    private E[] stack;
    private int blockSize;
    private int currentSize;
    private int bufferSize;

    public StackRA(int buffer) {
        if (buffer < 1)
            throw new IllegalArgumentException("Buffer size has to be 1 or greater");
        this.bufferSize = buffer;
        this.blockSize = buffer;
        this.currentSize = 0;
        this.stack = (E[]) new Object[blockSize];
    }

    public StackRA() {
        this(10);
    }

    public void push(E element) {
        if (this.currentSize == this.blockSize) {
            E[] temp = (E[]) new Object[this.blockSize + this.bufferSize];
            for (int i = 0; i < this.blockSize; i++) {
                temp[i] = this.stack[i];
            }
            this.stack = temp;
            this.blockSize = this.blockSize + this.bufferSize;
        }
        this.stack[this.currentSize] = element;
        this.currentSize++;
    }

    public E pop() {
        this.currentSize--;
        E val = this.stack[this.currentSize];
        if (this.currentSize <= (this.blockSize - this.bufferSize) && this.blockSize > this.bufferSize) {
            E[] temp = (E[]) new Object[this.blockSize - this.bufferSize];
            for (int i = 0; i < (this.blockSize - this.bufferSize); i++) {
                temp[i] = this.stack[i];
            }
            this.stack = temp;
            this.blockSize = this.blockSize - this.bufferSize;
        }
        return val;
    }

    public E peek() {
        return stack[this.currentSize - 1];
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int size() {
        return this.currentSize;
    }
}
