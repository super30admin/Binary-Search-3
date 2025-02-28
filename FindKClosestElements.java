import java.util.ArrayList;
import java.util.List;

// TC: O(n-k) n-k because at last the boundaries for smallest k elements is needed.
// SC: O(1) as no auxillary space is utilized

// Using 2-pointers approach to achieve the smallest k elements
public class FindKClosestElements {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3)); // [1,2,3,4]
        System.out.println(findClosestElements(new int[] { 1, 1, 2, 3, 4, 5 }, 4, -1)); // [1,1,2,3]
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (right - left + 1 > k) {
            int startDistance = x - arr[left];
            int endDistance = arr[right] - x;
            if (endDistance >= startDistance) {
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
}
