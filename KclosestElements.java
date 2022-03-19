// Time Complexity : O(log (n-k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Write the logic in binary search to find the first element that is among k closest element.
//Now create a list and copy k elemts to it from the start of which we had calculated.
// Return the the list of final k closet elements.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {    
        int l = 0;
        int h = arr.length - k;
        while(l < h){
            int mid = l + (h-l)/2;
            if(x-arr[mid] > arr[mid + k] - x){
                l = mid + 1;
            }
            else{
                h = mid;
        }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}