/*
Problem: https://leetcode.com/problems/find-k-closest-elements/
*/
// Approach 1: 2 pointer
// TC: O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        
        int left = 0, right = arr.length - 1;
        while (right - left + 1 > k) {
            int leftDistance = x - arr[left];
            int rightDistance = arr[right] - x;
            
            if (leftDistance > rightDistance) {
                ++left;
            } else {
                --right;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; ++i) {
            result.add(arr[i]);
        }
        return result;
    }
}


// Approach 2: Binary search
// Aim is to locate teh starting window from where we can give out k closest elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        int low = 0, high = arr.length - k;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            int distanceToXFromWindowStart = x - arr[mid];
            int distanceToXFromWindowEnd = arr[mid + k] - x;
            
            if (distanceToXFromWindowStart > distanceToXFromWindowEnd) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i = low; i < low + k; ++i) {
            result.add(arr[i]);
        }
        return result;
    }
}
 