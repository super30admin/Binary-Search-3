// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        
        if(arr==null || arr.length==0)
            return result;
        
        int low=0;
        int high=arr.length-1;
        
        
        while(high-low+1>k)
        {
            int distLeft=x-arr[low];
            int distRight=arr[high]-x;
            
            if(distLeft>distRight)
            {
                low++;
            }
            if(distLeft<=distRight)
            {
                high--;
            }
        }
        
        for(int i=low;i<=high;i++)
            result.add(arr[i]);
        
        return result;
    }
}