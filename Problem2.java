//Time = 
//Space = O(k)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
        // Binary search to find the closest element to x
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) {
                lo = mid;
                break;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        // Initialize the result list
        List<Integer> res = new ArrayList<>();
        // Add k elements to the result list, starting from the closest element
        int i = lo - 1, j = lo;
        while (k-- > 0) {
            if (i < 0 || (j < n && Math.abs(arr[i] - x) > Math.abs(arr[j] - x))) {
                res.add(arr[j++]);
            } else {
                res.add(arr[i--]);
            }
        }
        // Sort the result list in ascending order
        Collections.sort(res);
        return res;
    }
}
