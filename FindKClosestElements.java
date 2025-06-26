// TC: O(log (n - k))
// SC: O(k)
// Approach: Using Binary Search for range technique 
// Possible subarrays of length k start at indices 0 to arr.length - k
// Use Binary Search to find the starting index of the optimal subarray
// Compare distances from both ends
// If distance to arr[mid + k] is smaller, move window right (low = mid + 1)
// Else, move window left (high = mid)

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

  static List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    int low = 0;
    int high = arr.length - k;

    while (low < high) {
      int mid = low + (high - low) / 2;
      int dists = x - arr[mid];
      int diste = arr[mid + k] - x;

      if (dists > diste) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }

    for (int i = low; i < low + k; i++) {
      result.add(arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 1, 2, 3, 4, 5 };
    int k = 4;
    int x = 3;

    System.out.println(findClosestElements(arr, k, x));
  }
}
