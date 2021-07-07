/**
Binary Search Solution (not intuitive for me)
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(log(Number of elements in Array))

The idea is to perform Binary Search in a fashion by keeping low pointers fixed to first element and high to number of elements - k position. Then we compare difference of the element at mid position with the mid pointer + k position element difference. if mid difference > high pointer + mid element we move low pointer to mid position. if high + mid element differnece is greater we move high to mid + k position. We terminate the search once high and low pointer cross each other. Then we iterate k number of elements from low pointers **/


class Solution {
    List<Integer> results = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length < 1)
            return results;
        
        int low  = 0;
        int high = (arr.length) - k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            int diffMid  = Math.abs(arr[mid]  - x);
            int diffHigh = Math.abs(arr[mid + k] - x);
            
            if(diffMid > diffHigh)
                low = mid + 1;
            else
                high = mid;
        }
        
        for(int i = low; i<low + k; i++)
            results.add(arr[i]);
        
        return results;
    }
}
