/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

public class MyLinkedList<T> {

    class Node {
        T data;
        Node nextNode;

        Node(T value) {
            data = value;
        }
    }

    private Node head;
    private int size;

    MyLinkedList() {
        head = null;
        size = 0;
    }

    MyLinkedList(T... values) {
        for (T value : values) {
            pushBack(value);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object valueAt(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        int count = 0;

        while (count < index) {
            current = current.nextNode;
            count++;
        }

        return current.data;
    }

    public void pushFront(T value) {
        Node newHead = new Node(value);

        if (head == null) {
            head = newHead;
        } else {
            newHead.nextNode = head;
            head = newHead;
        }

        size++;
    }

    public T popFront() {
        if (head == null) {
            return null;
        } else {
            Node toReturn = head;
            head = head.nextNode;

            size--;
            return toReturn.data;
        }
    }

    public void pushBack(T value) {
        Node newTail = new Node(value);

        if (head == null) {
            head = newTail;
        } else {
            Node current = head;

            while (current.nextNode != null) {
                current = current.nextNode;
            }

            current.nextNode = newTail;
        }

        size++;
    }

    public T popBack() {
        if (head == null) {
            return null;
        } else {
            Node current = head;

            while (current.nextNode.nextNode != null) {
                current = current.nextNode;
            }

            Node toReturn = current.nextNode;
            current.nextNode = null;

            size--;
            return toReturn.data;
        }
    }

    public T front() {
        if (head != null) {
            return head.data;
        } else {
            return null;
        }
    }

    public T back() {
        if (head == null) {
            return null;
        }

        Node current = head;

        while (current.nextNode != null) {
            current = current.nextNode;
        }

        return current.data;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(value);
        Node current = head;

        if (index == 0) {
            newNode.nextNode = head;
            head = newNode;
        } else {
            int count = 0;

            while (count < index-1) {
                current = current.nextNode;
                count++;
            }

            newNode.nextNode = current.nextNode;
            current.nextNode = newNode;
        }

        size++;
    }

    public T erase(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node toReturn = head;
            head = head.nextNode;
            size--;
            return toReturn.data;
        } else {
            Node current = head;
            int count = 0;
            while (count < index - 1) {
                current = current.nextNode;
                count++;
            }

            Node toReturn = current.nextNode;
            current.nextNode = current.nextNode.nextNode;
            size--;
            return toReturn.data;
        }
    }

    public T valueNFromEnd(int n) {

        int position = size - n;

        if (position < 0 || position == size) {
            throw new IndexOutOfBoundsException();
        } else {
            int count = 0;
            Node current = head;

            while (count < position) {
                current = current.nextNode;
                count++;
            }

            return current.data;
        }
    }

    public void reverse() {
        if (head != null && size > 1) {
            Node prev = null;
            Node current = head;
            Node next = head.nextNode;

            while (current != null) {
                next = current.nextNode;
                current.nextNode = prev;
                prev = current;
                current = next;
            }

            head = prev;
        }
    }

    /* Remove first instance of a particular value in the linked list and return its index */
    public int removeValue(T value) {
        if (size == 0 || size == 1 && !head.data.equals(value)) {
            return -1;
        }

        if (size == 1 && head.data.equals(value)) {
            head = null;
            size--;
            return 0;
        }

        Node current = head;
        int count = 0;
        while (current.nextNode != null) {
            if (current.nextNode.data.equals(value)) {
                current.nextNode = current.nextNode.nextNode;
                size--;
                return count + 1;
            } else {
                current = current.nextNode;
                count++;
            }
        }

        return -1;
    }

    public void removeValueAllInstances(T value) {
        if (size == 0 || size == 1 && !head.data.equals(value)) {
            return;
        }

        if (size == 1 && head.data.equals(value)) {
            head = null;
            size--;
            return;
        }

        Node current = head;
        while (current.nextNode != null) {
            if (current.nextNode.data.equals(value)) {
                current.nextNode = current.nextNode.nextNode;
                size--;
            } else {
                current = current.nextNode;
            }
        }
    }

}
