// Time Complexity : O(nlog(k))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * 
 * We a modified binary search to find the search number of the result 
 * firstly we take high =len-k not high = len -1 because if the start is after that num we wont be able to get all k nums
 * 
 * during the search we are calculating 2 distance one is from x- mid (basically if that value is the starting value what will how far is it from x)
 * second value is arr[mid+k] - x 
 * we move the low or high based on those values
 * 
 * in when low becomes high, generally those 2 value will also be equal 
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}