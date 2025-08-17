class Solution {
    
    // Binary search solution.
    // TC: O(log(n-k)) + O(k)
    /** Explanation to use arr[mid + k] for comparison and not arr[mid + k - 1] 
    
    Block A: [arr[mid], ..., arr[mid + k - 1]]

    Block B: [arr[mid+1], ..., arr[mid + k]]

    Notice how they overlap — the only difference is:

    Block A includes arr[mid] on the left.

    Block B includes arr[mid + k] on the right.
    We’re deciding whether the left boundary (arr[mid]) or the right boundary (arr[mid+k]) is farther from x.
    The real decision is whether to:
    Keep the left element (arr[mid]), or
    Replace it with the new right element (arr[mid+k]).

    arr[mid] vs arr[mid+k] decides which block is closer overall.
    arr[mid + k - 1] is always in both blocks, so comparing with it is useless.
     */

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int l = 0;
        int r = arr.length - k; // cannot start after this index. 
        // we are trying to find the start point using binary search.

        while (l < r) {
            int mid = l + (r - l)/ 2; // mid referes to staring point of window.

            int distStart = x - arr[mid]; 
            int distEnd = arr[mid + k] - x;

            // if arr[mid + k] is better, we can ignore the window starting at mid and move to mid +1 
            if (distStart > distEnd) {
                l = mid + 1;
            } else { // othwise consider the mid as starting of the window.
                r = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; ++i) {
            result.add(arr[i]);
        }
        
        return result;


    }

    // 2 pointer technique
    // TC: O(n)
    // SC: O(1)
    public List<Integer> findClosestElements2Pointers(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        int l = 0;
        int r = arr.length - 1;
        
        while (r - l + 1 > k) {
            int distL = Math.abs(x - arr[l]);
            int distR = Math.abs(x - arr[r]);

            if (distL <= distR) {
                r--;
            } else {
                l++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; ++i) {
            result.add(arr[i]);
        }
        
        return result;
    }
}