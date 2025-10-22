public class StackLL<E> {
    private Node<E> TOP;

    public StackLL() {
        this.TOP = null;
    }

    public void push(E element) {
        this.TOP = new Node<E>(element, this.TOP);
    }

    public E pop() {
        if (this.TOP == null)
            return null;
        E top = this.TOP.value;
        this.TOP = this.TOP.next;
        return top;
    }

    public E peek() {
        return this.TOP.value;
    }

    public boolean isEmpty() {
        return this.TOP == null;
    }

    public int size() {
        Node<E> temp = this.TOP;
        int counter = 0;
        if (this.TOP == null)
            return 0;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
}
