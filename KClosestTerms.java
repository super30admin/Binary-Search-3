// Time Complexity : O(log(n - k))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class KClosestTerms {
    int n = arr.length;
    int low = 0; int high = n - k; // 6 - 4

    while (low < high) {
        int mid = low +(high - low)/2;
        int distS = x - arr[mid];
        int distE = arr[mid + k] - x;

        if (distS > distE) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = low; i < low+k; i++) {
        result.add(arr[i]);
    }
    return result;
}
