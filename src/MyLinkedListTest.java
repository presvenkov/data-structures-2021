/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void size() {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        assertThat(ll.size(), is(0));

        ll.pushBack(5);
        assertThat(ll.size(), is(1));
        ll.pushBack(11);
        assertThat(ll.size(), is(2));
    }

    @Test
    public void isEmpty() {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        assertTrue(ll.isEmpty());

        ll.pushBack(5);
        assertFalse(ll.isEmpty());
    }

    @Test
    public void valueAt() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');
        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('b'));
        assertThat(ll.valueAt(2), is('c'));
    }

    @Test
    public void pushFront() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.pushFront('Z');
        assertThat(ll.valueAt(0), is('Z'));
        assertThat(ll.valueAt(1), is('a'));
        assertThat(ll.valueAt(2), is('b'));
        assertThat(ll.valueAt(3), is('c'));
        assertThat(ll.size(), is(4));
    }

    @Test
    public void popFront() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.popFront();
        assertThat(ll.valueAt(0), is('b'));
        assertThat(ll.valueAt(1), is('c'));
        assertThat(ll.size(), is(2));
    }

    @Test
    public void pushBack() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.pushBack('Z');
        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('b'));
        assertThat(ll.valueAt(2), is('c'));
        assertThat(ll.valueAt(3), is('Z'));
        assertThat(ll.size(), is(4));
    }

    @Test
    public void popBack() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.popBack();
        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('b'));
        assertThat(ll.size(), is(2));
    }

    @Test
    public void front() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');
        assertThat(ll.front(), is('a'));
    }

    @Test
    public void back() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');
        assertThat(ll.back(), is('c'));
    }

    @Test
    public void insert() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.insert(1, 'Z');
        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('Z'));
        assertThat(ll.valueAt(2), is('b'));
        assertThat(ll.valueAt(3), is('c'));
        assertThat(ll.size(), is(4));
    }

    @Test
    public void erase() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c');

        ll.erase(0);
        assertThat(ll.valueAt(0), is('b'));
        assertThat(ll.valueAt(1), is('c'));
        assertThat(ll.size(), is(2));

        ll.erase(1);
        assertThat(ll.valueAt(0), is('b'));
        assertThat(ll.size(), is(1));
    }

    @Test
    public void valueNFromEnd() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c', 'd', 'e', 'f');

        assertThat(ll.valueNFromEnd(1), is('f'));
        assertThat(ll.valueNFromEnd(2), is('e'));
        assertThat(ll.valueNFromEnd(3), is('d'));
        assertThat(ll.valueNFromEnd(4), is('c'));
        assertThat(ll.valueNFromEnd(5), is('b'));
        assertThat(ll.valueNFromEnd(6), is('a'));
    }

    @Test
    public void reverse() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c', 'd', 'e', 'f');

        ll.reverse();
        assertThat(ll.valueAt(0), is('f'));
        assertThat(ll.valueAt(1), is('e'));
        assertThat(ll.valueAt(2), is('d'));
        assertThat(ll.valueAt(3), is('c'));
        assertThat(ll.valueAt(4), is('b'));
        assertThat(ll.valueAt(5), is('a'));
    }

    @Test
    public void removeValue() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'c', 'd', 'e', 'f');

        int removedIndex = ll.removeValue('c');
        assertThat(removedIndex, is(2));

        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('b'));
        assertThat(ll.valueAt(2), is('d'));
        assertThat(ll.valueAt(3), is('e'));
        assertThat(ll.valueAt(4), is('f'));

        assertThat(ll.size(), is(5));

    }

    @Test
    public void removeValueAllInstances() {
        MyLinkedList<Character> ll = new MyLinkedList<>('a', 'b', 'f', 'd', 'e', 'f', 'f', 'g');

        ll.removeValueAllInstances('f');

        assertThat(ll.valueAt(0), is('a'));
        assertThat(ll.valueAt(1), is('b'));
        assertThat(ll.valueAt(2), is('d'));
        assertThat(ll.valueAt(3), is('e'));
        assertThat(ll.valueAt(4), is('g'));

        assertThat(ll.size(), is(5));
    }
}
