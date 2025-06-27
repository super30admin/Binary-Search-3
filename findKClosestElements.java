//find the starting index of the subarray of length k whose elements are closest to x using binary search. Compare distances between x and the edges of the current window to decide whether to move the window left or right. Once found, collect the k elements starting from that index.
//Time Complexity: O(log(n - k) + k)
//Space Complexity: O(k)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        List<Integer> result = new ArrayList<>();
        while(low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}