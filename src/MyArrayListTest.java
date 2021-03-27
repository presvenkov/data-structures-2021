/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MyArrayListTest {

    @org.junit.Test
    public void isEmpty() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        assertThat(myArrayList.isEmpty(), is(true));
    }

    @org.junit.Test
    public void at() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');
        assertThat(myArrayList.at(0), is('a'));
        assertThat(myArrayList.at(1), is('b'));
        assertThat(myArrayList.at(2), is('c'));
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void atThrowsExceptionWhenIndexOutOfBounds() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');
        assertThat(myArrayList.at(0), is('a'));
        assertThat(myArrayList.at(1), is('b'));
        assertThat(myArrayList.at(2), is('c'));

        assertThat(myArrayList.at(3), is('d'));
    }

    @org.junit.Test
    public void push() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        assertThat(myArrayList.toString(), is("[]"));
        myArrayList.push(2);
        assertThat(myArrayList.toString(), is("[2]"));
        myArrayList.push(5);
        myArrayList.push(12);
        myArrayList.push(320);
        assertThat(myArrayList.toString(), is("[2, 5, 12, 320]"));
    }

    @org.junit.Test
    public void insert() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');
        assertThat(myArrayList.at(0), is('a'));
        assertThat(myArrayList.at(1), is('b'));
        assertThat(myArrayList.at(2), is('c'));

        myArrayList.insert(1, 'D');

        assertThat(myArrayList.toString(), is("[a, D, b, c]"));
    }

    @org.junit.Test
    public void prepend() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');
        assertThat(myArrayList.at(0), is('a'));
        assertThat(myArrayList.at(1), is('b'));
        assertThat(myArrayList.at(2), is('c'));

        myArrayList.prepend('Z');
        assertThat(myArrayList.at(0), is('Z'));
        assertThat(myArrayList.toString(), is("[Z, a, b, c]"));
    }

    @org.junit.Test
    public void pop() {
        MyArrayList<Character> myArrayList = new MyArrayList<>();
        assertNull(myArrayList.pop());

        myArrayList.push('a');
        myArrayList.push('b');

        assertThat(myArrayList.toString(), is("[a, b]"));
        myArrayList.pop();
        assertThat(myArrayList.toString(), is("[a]"));
        myArrayList.pop();
        assertThat(myArrayList.toString(), is("[]"));
    }

    @org.junit.Test
    public void delete() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');

        myArrayList.delete(1);
        assertThat(myArrayList.toString(), is("[a, c]"));
    }

    @org.junit.Test
    public void find() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c');

        assertThat(myArrayList.find('a'), is(0));
        assertThat(myArrayList.find('b'), is(1));
        assertThat(myArrayList.find('c'), is(2));
        assertThat(myArrayList.find('d'), is(-1));
    }

    @org.junit.Test
    public void remove() {
        MyArrayList<Character> myArrayList = new MyArrayList<>('a','b','c','b');

        myArrayList.remove('b');
        assertThat(myArrayList.toString(), is("[a, c]"));
    }
}
