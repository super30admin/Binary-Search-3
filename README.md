# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

//Keep on dividing until we reach the x ^ 0 condition which is equal to 1
//recursion 
//Time Complexity : O(log(N))
//Space Complexity : O(1)

class Solution {
    public double myPow(double x, int n) {
        //base
        if(n == 0) return 1.00; 
        
        //logic
        double result = myPow(x,n/2); 
        if(n % 2 == 0){
            return result * result; 
        }
        else{
            if(n < 0)
            return result * result * 1 / x; 
            else return result * result * x; 
        }
    }
}

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)


//Binary Search Solution
//Time Complexity = O(log(N))
//Space Complexity = O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>(); 
        int low = 0; 
        int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high-low)/2;
            int disF = x - arr[mid]; 
            int disL = arr[mid+k] - x;
            
            if(disF > disL){
                low = mid + 1;
            }else{
                high = mid;
            }
        }  
       
        
        for(int i = low ; i < low + k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}


//Two Pointer Solution
//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>(); 
        int low = 0; 
        int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high-low)/2;
            int disF = x - arr[mid]; 
            int disL = arr[mid+k] - x;
            
            if(disF > disL){
                low = mid + 1;
            }else{
                high = mid;
            }
        }  
       
        
        for(int i = low ; i < low + k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}

