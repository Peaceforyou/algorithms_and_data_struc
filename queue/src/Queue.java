

public class Queue<T> {
    private Node<T> last = null;
    private Node<T> first = null;
    private int size = 0;


    private  static class Node<T> {
            Node<T> next;
            T value;

            public Node(T value) {
                this.value = value;
            }
        }




    public void offer(T val) {
        Node<T> newNode = new Node<>(val);
        if (isEmpty()) {
            last = newNode;
            first = newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }




    public T poll() {
        if (isEmpty()) {
            return null;
        }

        T toReturn = first.value;
        first = first.next;
        if (first == null) {
            last = null;
        }
        size--;
        return toReturn;
    }
    public T peek() {
        if (isEmpty()) return null;
        return first.value;
    }
    public void clear() {
        Node<T> current = first;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            current.value = null;
            current = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {return (size == 0);}

    public int size() {return size;}

}


