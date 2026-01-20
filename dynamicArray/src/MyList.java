import java.util.Arrays;

public class MyList<T>{
    private int capacity = 10;
    private int size = 0;
    private Object[] array = new Object[capacity];


    public void add(T val) {
        overFlow();
        array[size] = val;
        size++;
    }

    public void add(int id,T val) {
        checkBoundsForAdd(id);
        overFlow();
        for (int i = size - 1; i >= id; i--) {
            array[i + 1] = array[i];
        }
        array[id] = val;
        size++;
    }
    private void checkBoundsForAdd(int id) {
        if (id < 0 || id > size) {
            throw new IndexOutOfBoundsException("Index out of bound!");
        }
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

    public void remove(int id) {
        checkBounds(id);
        for (int i = id; i < size - 1;i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }
    public boolean remove(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null ? object == null : array[i].equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
}
