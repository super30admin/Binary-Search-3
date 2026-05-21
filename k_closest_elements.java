// Time Complexity : O(log(n-k) + k) because we use Binary Search to find the window and then collect k elements
// Space Complexity : O(k) for storing the final result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Binary Search to find the starting index of the window of size k containing the closest elements to x.
// At every midpoint, we compare the distance of x from the left boundary and the element just outside the right boundary of the window.
// Once the optimal window is found, we collect the k elements starting from that index.

class Solution {

    public List<Integer> findClosestElements(
        int[] arr,
        int k,
        int x
    ) {

        int n = arr.length;

        int low = 0;

        int high = n - k;

        List<Integer> result =
            new ArrayList<>();

        // binary search on window start index
        while (low < high) {

            int mid =
                low + (high - low) / 2;

            // distance from left boundary
            int distS = x - arr[mid];

            // distance from right outside element
            int distE = arr[mid + k] - x;

            // move window right
            if (distS > distE) {

                low = mid + 1;
            }

            // keep/move window left
            else {

                high = mid;
            }
        }

        // collect k closest elements
        for (int i = low; i < low + k; i++) {

            result.add(arr[i]);
        }

        return result;
    }
}