/**
Two Pointer Solution
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(Nums of elements in Array)

The idea is to keep two pointers at first and last position of the array. Check absolute differences of array elements with x and then move the largest pointer from the first and second pointer. Once, number of elements between low and high is equal to k we have the solution. Then iterate from low pointer to high pointer to get the required elements.
**/
class Solution {
    List<Integer> results = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length < 1)
            return results;
        
        int low  = 0;
        int high = arr.length - 1;
        
        while(high - low > k - 1){
            int diffLow  = Math.abs(arr[low]  - x);
            int diffHigh = Math.abs(arr[high] - x);
            
            if(diffLow > diffHigh)
                low++;
            else
                high--;
        }
        
        for(int i = low; i<= high; i++)
            results.add(arr[i]);
        
        return results;
    }
}
