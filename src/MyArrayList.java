/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

public class MyArrayList<T> {

    int capacity = 1;
    int size = 0;
    Object[] items;

    public MyArrayList() {
        items = new Object[capacity];
    }

    public MyArrayList(T... elements) {
        capacity = elements.length*2;
        items = new Object[elements.length*2];

        for (T elem : elements) {
            push(elem);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object at(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            return items[index];
        }
    }

    public void push(T value) {
        if (size == capacity) {
            resize(capacity*2);
        }

        size++;
        items[size-1] = value;
    }

    public void insert(int index, T value) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (size == capacity) {
            resize(capacity*2);
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i-1];
        }

        items[index] = value;
        size++;
    }

    public void prepend(T value) {
        insert(0, value);
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }

        Object toReturn = items[size-1];
        size--;
        if (capacity/4 >= size) {
            resize(capacity/4);
        }

        return toReturn;
    }

    public void delete(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size-1; i++) {
            items[i] = items[i+1];
        }

        size--;
    }

    public boolean remove(T item) {
        boolean anythingRemoved = false;

        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                delete(i);
                anythingRemoved = true;
            }
        }

        return anythingRemoved;

    }

    public int find(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size-1; i++) {
            sb.append(items[i] + ", ");
        }

        if (size > 0) {
            sb.append(items[size-1]);
        }

        sb.append("]");
        return String.valueOf(sb);
    }

    private void resize(int newCap) {
        Object[] tempItems = new Object[newCap];

        for (int i = 0; i < size; i++) {
            tempItems[i] = items[i];
        }

        items = tempItems;
        capacity = newCap;
    }
}
