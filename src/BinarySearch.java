public class BinarySearch {

    public static boolean binarySearchIterative(int[] array, int target) {

        if (array.length == 0) {
            return false;
        }

        if (array.length == 1) {
            return array[0] == target;
        }

        int left = 0;
        int right = array.length - 1;
        int middle = left + (right - left)/2;

        while (left < right) {
            if (array[middle] > target) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                return true;
            }

            middle = left + (right - left)/2;
        }
        return false;
    }

    public static boolean binarySearchRecursive(int[] array, int target, int left, int right) {
        if (array.length == 0) {
            return false;
        }

        if (array.length == 1) {
            return array[0] == target;
        }

        //base case
        if (left > right) {
            return false;
        }

        int middle = left + (right - left)/2;

        if (array[middle] == target) {
            return true;
        } else if (array[middle] < target) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }

        return binarySearchRecursive(array, target, left, right);
    }
}
