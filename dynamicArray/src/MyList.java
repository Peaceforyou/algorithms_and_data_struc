import java.util.Arrays;

public class MyList<T> {
    private int capacity = 10;
    private int size = 0;
    private Object[] array = new Object[capacity];


    public void add(T val) {
        overFlow();
        array[size] = val;
        size++;
    }

    public T get(int index) {
        checkBounds(index);
        return (T) array[index];
    }



    private void overFlow() {
        if (size == capacity) {
            capacity += capacity / 2;
            array = Arrays.copyOf(array, capacity);
        }
    }

    private void checkBounds(int index) {
        if ((index < 0) || (index >= size)) throw new IndexOutOfBoundsException("Index out of bound!");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0) {
            sb.append("[]");
        }
        else {
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            sb.append(array[size - 1]);
            sb.append("]");
        }
        return sb.toString();
    }

    public int size() {return size;}
}
