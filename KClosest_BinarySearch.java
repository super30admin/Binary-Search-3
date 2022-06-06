// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : why doesn't the Math.abs not work for this use case - [1,1,2,2,2,2,2,3,3] x = 3, k = 3????
// Your code here along with comments explaining your approach: binary search to find starting point of the final array

public class KClosest_BinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int low = 0;
        int high = arr.length - k; // as the starting point cannot exist after this point onwards
        while (low < high) {
            int mid = low + (high - low) / 2;
            int deltaL = x - arr[mid]; // Math.abs(x - arr[mid]);
            // mid+k as we check the end of the res array
            int deltaR = arr[mid + k] - x; // Math.abs(x - arr[mid+k]);
            if (deltaL > deltaR) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
