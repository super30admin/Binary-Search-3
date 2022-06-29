//https://leetcode.com/problems/find-k-closest-elements/
// Time Complexity :O(log(n-k))  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        int n=arr.length;
        //here we are trying to find the range 
        int low=0,high=n-k; //high pointer is pointing to the last possible lower element of the range
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int distS=x-arr[mid];//start distance
            int distL=arr[mid+k]-x; //end distance
            if(distS>distL) //distance is like a balance and if left side is more move the low pointer
                low=mid+1;
            else
                high=mid;
        }
        for(int i=low;i<low+k;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}