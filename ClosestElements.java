/** Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order 
* TC O(logn+k). O(logn) is for the time of binary search and O(k) is for adding k elements to list.
* SC O(1)
*/
class Solution {
    List<Integer> result;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        result  = new ArrayList<Integer>();
        if (arr == null || arr.length == 0)
            return result;
        
        int lo = 0, hi = arr.length-k;
        int mid = search(arr, lo, hi, x, k);
        for (int i = mid; i < mid + k; i++){
            result.add(arr[i]);
        }
        return result;
     }
    
    
    
    private int search(int [] arr, int lo, int hi, int x, int k) {
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            int last = mid + k -1;
            if ((mid-1 >= 0) && ((x  - arr[mid-1]) <= (arr[last] - x))) {
                hi = mid-1;
            }
            else if ((last + 1 < arr.length) && ((x  - arr[mid]) > (arr[last+1] - x))) {
                lo = mid+1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }
}

