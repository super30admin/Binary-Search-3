# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1.0;
        

        while (n != 0) {
            if (n % 2 != 0) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }

        return result;
    }
}




## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

class Solution {
     public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = arr.length-1;

        while(end-start+1 > k) {
            int startD = x - arr[start];
            int endD = arr[end] - x;
            if(startD > endD) {
              start++;
            } else {
              end--;
            }
        }

        for(int i = start; i<=end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}




