// Time Complexity : O(lon (n-k) + k) where n is the number of elements and k is the size of the window
// Space Complexity : O(n11)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using binary search to find the start of the window with size k where the elements are closest to the target. We take the window of k+1 to resolve the tie to take the minimum number of the two.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        int low = 0, high = n - k;

        while(low < high){
            int mid = low + (high - low)/2;

            // not taking the absolute distance here for cases with duplicate elements
            // [1,2,2,2,2,3], k=3
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                low = mid + 1;
            }else{
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
