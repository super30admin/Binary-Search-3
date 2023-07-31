// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes     
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// our aim to find the starting index of the k closet elements so we have h as the length of the array -k 
// we take one extra element on the right to see if it is equal to the left most element 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l =0;
        int h= arr.length -k;
        while( l<h)
        {
            int mid = l + (h-l)/2;
            int lDist = x-arr[mid];
            int hDist = arr[mid+k]-x;
            if(lDist>hDist)
            {
                l = mid+1;
            }else {
                h = mid ; // one extra value on the right
            }
        }
        List<Integer> result= new ArrayList<>(); 
        for(int z=l;z<l+k;z++)
        {
            result.add(arr[z]);
        }
        return result;
    }
}