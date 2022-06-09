
// Time Complexity : O(n-k)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//used two pointer approach one from 0 and other from last index.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0,high=arr.length-1;
        while(high-low>=k){
            if(Math.abs(arr[low]-x)>Math.abs(arr[high]-x)) low=low+1;
            else high=high-1;
        }
        List<Integer>result = new ArrayList<>();
        for(int i=low;i<=high;i++){
            result.add(arr[i]);
        }
        return result;
    }
}