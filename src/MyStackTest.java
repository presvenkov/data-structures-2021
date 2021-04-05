import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyStackTest {

    @Test
    public void push() {

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.getCurrentSize(), is(3));
    }

    @Test
    public void pop() {

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer popped = stack.pop();

        assertThat(stack.getCurrentSize(), is(2));
        assertThat(popped, is(3));
    }

    @Test
    public void top() {

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.top(), is(3));
        stack.pop();
        assertThat(stack.top(), is(2));
        stack.pop();
        assertThat(stack.top(), is(1));
        stack.pop();
        assertNull(stack.top());
    }

    @Test
    public void getCurrentSize() {

        MyStack<Integer> stack = new MyStack<>();

        assertThat(stack.getCurrentSize(), is(0));

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.getCurrentSize(), is(3));

        stack.pop();
        stack.pop();
        stack.pop();

        assertThat(stack.getCurrentSize(), is(0));
    }
}
