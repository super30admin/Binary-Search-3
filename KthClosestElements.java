// Time Complexity : O(logn+k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : use binary search to find mid. Let's assume the window of k elements starts at mid. Find dist of 
/// window's starting element with x and end element with x. If distance with start is more then move low to mid+1,
/// else migh to mid. Lastly, copy k elements from low to resultant array
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int low = 0, high = arr.length-k;
        while(low<high){
            int mid = low + (high-low)/2;//start
            int end = mid+k;
            int dists = x-arr[mid];
            int diste = arr[end]-x;
            if(dists>diste){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}