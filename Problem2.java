// Time Complexity - O(log n + k) where n is the number of elements in the array and k is the number of elements that should be returned.
// Space Complexity - O(1)
// This Solution worked on LeetCode

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)   return result; // Edge Case
        int low = 0;    // Low starts at 0
        int high = arr.length - k;        high starts at length - k
        while(low < high){                          // Loop until low and high meets
            int mid = low + (high - low)/2;         // mid of low and high
            int diffL = Math.abs(arr[mid] - x);         // Left side value diffL is the absolute difference between value at mid and x
            int diffR = Math.abs(arr[mid + k] - x);      // Right side diffR is the absolute difference between value at kth value from mid and x
            \\ This logic is used to check which side from mid will have the k values closest to x
            if(diffL > diffR){    // If diffL is greater than diffR it means the left side has greater difference from x and hence low should be moved to right side of mid.
                low = mid + 1;   
            }
            else{
                high = mid;     // otherwise high is moved to mid to consider the left side as the desirable side for k elements
            }
        }
        for(int i = low; i< low + k; i++){    // finally, the low is obtained and we add the k elements from low to the result since the array is sorted already
            result.add(arr[i]);
        }
        return result;
    }
}
