# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution {
    // TC O(log n) SC O(1)
    public double myPow(double x, int n) {
        //base case
        if(n==0) return 1.0;
        
        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){
        return result * result;
        }
        if(n%2 == 1){
            return result * result * x;
        } else{
            return result * result * 1 / x;
        }
    }
}

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

class Solution {
    //TC O(logn) SC O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        int low = 0;
        int high = arr.length - k;
        
        while (low<high){
            int mid = low + (high - low)/2;
            
            int dists = x - arr[mid];
            int diste = arr[mid+k] - x;
            
            if(dists > diste){
                low = mid +1;
            }else{
                high = mid;
            }
        
        }
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}



