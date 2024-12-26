/*
Time complexity: O(log(N)+k).

The initial binary search to find where we should start our window costs O(log(N)). Our sliding window initially
starts with size 0 and we expand it one by one until it is of size k, thus it costs O(k) to expand the window.

Space complexity: O(1)

We only use integer variables left and right that are O(1) regardless of input size. Space used for the output
is not counted towards the space complexity.
*/
import java.util.ArrayList;
import java.util.List;

class KClosestElementsBSSlidingWindow {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0, high = n;
        List<Integer> result = new ArrayList<>();

        // Base case
        if (n == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }

            return result;
        }

        while(low < high)
        {
            int mid = low + (high-low)/2;

            if(arr[mid] < x) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        // Initialize sliding window
        low = low - 1; // Start from one element before the insertion point
        high = low + 1;

        // Expand the window to include k elements
        while (high - low -1 < k)
        {
            if (low < 0) {
                high++;
            } else if (high == n ||  Math.abs(x - arr[low]) <=  Math.abs(arr[high] - x)) {
                low--;
            } else {
                high++;
            }
        }

        // Collect the k closest elements
        for (int i = low+1; i < high; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}