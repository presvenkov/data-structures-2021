/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

public class MyStack<T> {

    int initialSize = 1;
    Object[] elements;
    int size = 0;

    public MyStack() {
        elements = new Object[initialSize];
    }

    public void push(T value) {
        if (size == elements.length) {
            resize(elements.length*2);
        }

        elements[size++] = value;
    }

    public T pop() {
        if (size == 0) {
            return null;
        } else {
            Object toReturn = elements[size-1];
            size--;

            if (size < elements.length/4) {
                resize(elements.length/2);
            }

            return (T)toReturn;
        }
    }

    public Object top() {
        if (size < 1)
            return null;
        else {
            return elements[size-1];
        }
    }

    public int getCurrentSize() {
        return size;
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }
}
