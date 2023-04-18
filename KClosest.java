// The time complexity of this implementation is O(n)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            if (leftDiff <= rightDiff) {
                right--;
            } else {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int[] arr = {1, 2, 3, 4, 5};
            int k = 4;
            int x = 3;
            List<Integer> result = solution.findClosestElements(arr, k, x);
            System.out.println("The " + k + " closest elements to " + x + " in the array " + Arrays.toString(arr) + " are: " + result);

            arr = new int[]{1, 2, 3, 4, 5};
            k = 4;
            x = -1;
            result = solution.findClosestElements(arr, k, x);
            System.out.println("The " + k + " closest elements to " + x + " in the array " + Arrays.toString(arr) + " are: " + result);

            arr = new int[]{1, 2, 3, 4, 5};
            k = 2;
            x = 6;
            result = solution.findClosestElements(arr, k, x);
            System.out.println("The " + k + " closest elements to " + x + " in the array " + Arrays.toString(arr) + " are: " + result);
        }
}
