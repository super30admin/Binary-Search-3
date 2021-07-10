// Time Complexity :  O(n)
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length-1;
        List<Integer> result = new ArrayList<>(k);
        while((r-l+1)>k)
        {
            if(Math.abs(arr[l]-x)>Math.abs(arr[r]-x))
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        for(int i = l;i<=r;i++)
        {
            result.add(arr[i]);
        }
        return result;
        
    }
}