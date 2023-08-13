// Time Complexity : O(log N)
// Space Complexity : O(log N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//We will have to find the range of the k closest integers. So we will do a binary search to find the starting index of the closest element to x. We will start from low =0 and the final index of the starting element can be length of the array-k. If the starting index if greater than high then we need to move towards the right, so we make low=mid+1 otherwise we need to mve towards the right, so we make high=mid.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-k;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int sDist=x-arr[mid];
            int eDist=arr[mid+k]-x;

            if(sDist>eDist)
            {
                low=mid+1;
            }
            else
            {
                high=mid;
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=low;i<low+k;i++)
        {
            result.add(arr[i]);
        }
        return result;

    }
}

//Iterative

class Solution {

    public double myPow(double x, int n) 
    {
        if(n<0)
        {
            x=1/x;
            n*=-1;
        }
        double result=1.0;
        while(n!=0)
        {
            if(n%2!=0)
            {
                result=result*x;
            }
            x=x*x;
            n=n/2;
        }
        return result;
    }
}