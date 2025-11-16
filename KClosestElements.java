// Time Complexity : O(log(n-k)) + O(k).
// Space Complexity : O(1).
// Did this code successfully run on Leetcode : Yes
// Approach : We need to find the start index of the result array by performing the Binary Search from 0 to n-k elements. We compute the mid
// and check the difference at mid and mid+k elements and move the low to right if diffAtStart is greater than diffAtEnd. Else, the other
//  way. Once we arrive at low until low,high dont cross each other, we add low to low+k elements in the result.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k; // to find the start index of the result

        while(low < high){
            int mid = low + (high-low)/2;
            int diffAtStart = x-arr[mid];
            int diffAtEnd = arr[mid+k]-x;
            if(diffAtStart > diffAtEnd){// if diffAtStart is greater than diffAtEnd, move window right, else move left
                low = mid+1;
            }else{
                high = mid;
            }

        }

        List<Integer> result = new ArrayList<>();
        for(int i = low ; i < low+k; i++){//result array from low to low+k
            result.add(arr[i]);
        }
        return result;
    }
}