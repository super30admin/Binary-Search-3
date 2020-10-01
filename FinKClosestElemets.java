// Time Complexity : O(logn + k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Binary Search
class Solution {
    
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k <= 0) 
            return Collections.emptyList();
        int n = arr.length;

        int lo = 0;
        int hi = n - k;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int left_dis = Math.abs(x - arr[mid]);
            int right_dis = Math.abs(x-arr[mid + k]);
            
            if (left_dis > right_dis){ 
                lo = mid +1;
            }else{
                if(arr[mid] == arr[mid+k]){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = lo; i < lo + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}