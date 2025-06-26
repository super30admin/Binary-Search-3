Approach (in 3 sentences):
We use binary search to find the left boundary of a window of size k such that the k elements are the closest to x.
The idea is to shift the window [mid, mid+k) based on comparing the distances of x to the start (arr[mid]) and end (arr[mid+k]) of the window.
Once the optimal starting index is found, we add the k elements directly to the result list.

Time Complexity:
O(log(n - k)) for binary search
O(k) to store the result by iterating over k elements
Total: O(log(n - k) + k)

📦 Space Complexity:
O(k) for the result list (excluding input space)
No extra space beyond that (not counting output)

  

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int h = arr.length-k;
        int mid=0;
        while(l < h){
            mid = l + (h - l)/2;
            int distS = x - arr[mid] ;
            int distE = arr[mid + k] - x;
            if(distS > distE)
                l = mid + 1;
            else
                h = mid;
        }
        for(int i = l; i<l+k; ++i)
            res.add(arr[i]);
        return res;
    }
}
