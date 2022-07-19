// Time Complexity: O(log(n-k))
// Space Complexity: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
         int lo = 0, hi = arr.length - k;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (x - arr[mid] > arr[mid+k] - x)
            lo = mid + 1;
        else
            hi = mid;
    }
        for(int i=lo;i<lo+k;i++){
            res.add(arr[i]);
        }
    return res;
    }
}
