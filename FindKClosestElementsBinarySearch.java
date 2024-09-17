// TC: O(log(n - k))
// SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return res;
        }
        // Using binary search to find the 1st element of the resultant k elements
        int low, high, mid;
        low = 0;
        high = arr.length - k;
        while(low < high) {
            mid = low + (high - low) / 2;

            int dFirst = x - arr[mid];
            int dLast = arr[mid + k] - x;

            if(dFirst > dLast) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for(int i = low; i < low + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}