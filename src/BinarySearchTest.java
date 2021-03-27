/* © 2021 Preslav Venkov <https://github.com/presvenkov/data-structures-2021> */

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {


    @Test
    public void binarySearchIterative() {
        int[] emptyArray = {};

        assertFalse(BinarySearch.binarySearchIterative(emptyArray, 5));

        int[] oneElementArray = {3};

        assertTrue(BinarySearch.binarySearchIterative(oneElementArray, 3));
        assertFalse(BinarySearch.binarySearchIterative(oneElementArray, 5));

        int[] multiElementArray = {1, 5, 7, 9, 20, 50, 300, 456, 678, 3456};

        assertTrue(BinarySearch.binarySearchIterative(multiElementArray, 5));
        assertFalse(BinarySearch.binarySearchIterative(multiElementArray, 344));
    }

    @Test
    public void binarySearchRecursive() {
        int[] emptyArray = {};

        assertFalse(BinarySearch.binarySearchRecursive(emptyArray, 5, 0, emptyArray.length));

        int[] oneElementArray = {3};

        assertTrue(BinarySearch.binarySearchRecursive(oneElementArray, 3, 0, oneElementArray.length));
        assertFalse(BinarySearch.binarySearchRecursive(oneElementArray, 5, 0, oneElementArray.length));

        int[] multiElementArray = {1, 5, 7, 9, 20, 50, 300, 456, 678, 3456};

        assertTrue(BinarySearch.binarySearchRecursive(multiElementArray, 5, 0, multiElementArray.length));
        assertFalse(BinarySearch.binarySearchRecursive(multiElementArray, 344, 0, multiElementArray.length));
    }
}
