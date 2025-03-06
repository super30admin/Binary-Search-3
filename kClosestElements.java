// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take 2 pointers initially as low at 0 index and high and length - k index. Iterate until low<high and find mid and distS is
 * distance between x and mid value and distE is distance between mid+k value and x. If distS is greater move low to mid+1 else
 * move high to mid. Finally take all the elements from low to low+k position and return the list.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}