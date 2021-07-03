// Time Complexity : O(n) n-length of the array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
https://leetcode.com/problems/find-k-closest-elements/submissions/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     int low=0;int high=arr.length-1;
     List<Integer> result=new ArrayList<>();
        while(high-low>k-1)
        {
            int dL=Math.abs(arr[low]-x);
            int dR=Math.abs(arr[high]-x);
            if(dL<=dR)
                high--;
            else
                low++;
          
        }
        for(int i=low;i<low+k;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}