public class StackRA<E> {
    private E[] stack;
    private int blockSize;
    private int currentSize;
    private int buffer;

    public StackRA(int buffer) {
        if (buffer < 1) throw new 
    }

    public StackRA() {
        StackRA(10);
    }

    public void push(E element) { //add new thing to end of list
        size++;
        E[] temp = new E[size];
        //dont know what to do about the error here
        for(int i=0; i<size;i++){ //copy array into new array
            temp[i]=stack[i];
        }
        temp[size-1]=element;
        stack=temp;
    }

    public E pop() { //return value at top of list
        size--;
        E[] temp = new E[size];
        for(int i=0; i<size;i++){ //copy array into new array
            temp[i]=stack[i];
        }
        E val = stack[size];
        stack=temp;
        return val;
    }

    public E peek() {
        return stack[size-1]; //return last value in stack
    }

    public boolean isEmpty() {
        return stack.length==0;
    }

    public int size() {
        return size;
    }
}
