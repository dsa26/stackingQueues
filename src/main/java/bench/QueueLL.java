package src.main.java.bench;

public class QueueLL<E> {
    private Node<E> HEAD;
    private Node<E> TAIL;

    public QueueLL() {
        this.HEAD = null;
        this.TAIL = null;
    }

    public void enqueue(E element) {
        if (this.TAIL == null) {
            this.TAIL = new Node<E>(element, null);
            this.HEAD = this.TAIL;
        } else {
            this.TAIL.next = new Node<E>(element, null);
            this.TAIL = this.TAIL.next;
        }
    }

    public E dequeue() {
        if (this.HEAD == null)
            return null;
        E head = this.HEAD.value;
        this.HEAD = this.HEAD.next;
        return head;
    }

    public boolean isEmpty() {
        return this.HEAD == null || this.TAIL == null;
    }

    public int size() {
        if (this.HEAD == null)
            return 0;
        Node<E> temp = this.HEAD;
        int counter = 0;
        while (temp.next != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
}
