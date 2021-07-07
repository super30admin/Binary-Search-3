/*
Time: O(log N) + k (for binary search of start of the window and then getting k closest elements)
Space: O(1) auxilliary space
Algorithm:
=========
1. Find where window can start for k closest elements to x using binary search. Minimum where window can start is 0, max is array length - k
2. Perform binary search by observing distance between x and (mid+k) vs x and (mid). If mid is closer, then maximum start of window can be mid
(everything after mid+k-1 has to be ignored, so maximum start has to be mid)
3. If mid+k is closer, then minimum start of window can be mid+1 (everything before mid is ignored)
4. Update till low >= high, and then return elements at indices from low to low+k 
*/
class Solution {
    List<Integer> result;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        result = new ArrayList<Integer>();
        if( arr == null || arr.length == 0) return result;
        int n = arr.length;
        int low = 0, high = n - k;              // possible start of the window's low and highs
        
        while(low < high) {                 
            int mid = low + (high - low)/2;             
            if(x - arr[mid] > arr[mid+k] - x) {     // distance(mid) > distance(mid+k)
                low = mid+1;                        // update minimum start window to mid+1 (everything below mid ignored)
            }
            else 
                high = mid;                 // distance(mid) < distance(mid+k) => update maximum start window to mid (everything abovr mid+k-1) ignored 
        }
        
        for(int i = low; i < low+k; i++) {  // copy k elements from low to low+k to result
            result.add(arr[i]);
        }
        
        return result;
    }
}