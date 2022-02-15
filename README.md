# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution {
    //Time Complexity: O(log n)
    //Space Complexity: O(log n)
    public double myPow(double x, int n) {
        //base case
        if( n== 0) return 1.00;
        //recurse
        double result = myPow(x, n/2);
        //check if the power is even or odd
        if(n%2 == 0) 
        {
            return result * result;
        }else
        {
            //check if the power is positive or negative
            if(n>0)
            {
                return result* result * (x);
            }
            else
            {
                return result * result * (1/x);
            }
        }
    }
}

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

class Solution {
    //Time Complexity: O(log(n-k)) + O(k)
    //Space Complexity: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low =0;
        int high = n-k;
        while(low<= high)
        {
            int mid = low + (high-low)/2;
            int distS = x- arr[mid];
            int distL = mid+k <n?arr[mid+k] -x:Integer.MAX_VALUE;
            if(distS > distL) low = mid +1;
            else high = mid-1;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low; i< low +k ; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}



