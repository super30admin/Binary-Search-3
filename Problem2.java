// ## Problem2 
// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Complexity : O(log(n - k)) -Binary Seacrch  + O(k) - Gothrough k elements to form result
// Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;

        int low = 0, high = n - k;
        // Have a binary search to find the low and high values as it is a sorted array
        // Where if we find the low value we could find the high with low + k
        while(low < high){
            int mid = low + (high - low)/2;
            // distance from left
            int distS = x - arr[mid];
            // distance from right
            int distE = arr[mid + k] - x;
            // if left is greater then low moves to mid + 1
            if(distS > distE){
                low = mid + 1;
            }else{ // else high is changed to mid
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i< low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}