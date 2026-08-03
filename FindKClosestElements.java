class Solution {
    /*
        TC - O(log(n-k) + k)
        SC - O(1), if we don't consider the output list
        Solution - Instead of checking every possible window, use binary search on the starting index of the window.
        The possible starting index ranges from 0 to arr.length - k.
        For each mid:
        Compare the distance from x to the left side of the window (arr[mid]) and the element just after the window (arr[mid + k]).
        If the left side is farther (x - arr[mid] > arr[mid + k] - x), move the window right.
        Otherwise, move the window left.
        Once binary search finishes, low is the start index of the optimal window.
        Return the k elements starting from low.
    */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int low = 0;
       int high = arr.length - k;

       while (low < high) {
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
       }

       List<Integer> result = new ArrayList<>();
       for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
       }

       return result;
    }
}