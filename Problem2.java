import java.util.*;
import java.util.stream.Collectors;

class Problem2 {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == k) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList());
        }
        int left = 0;
        int right = arr.length;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left = left - 1;
        right = left + 1;
        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
                continue;
            }

            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        int k = 4, x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }
}
