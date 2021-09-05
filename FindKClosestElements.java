package com.s30.common.ds;
//Time Complexity  O(log(n-k)) + O(k)
//space complicity = o(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        if( arr == null || arr.length == 0){
            return result ;
        }
        int low = 0 , high = arr.length - k ;
        while ( low < high)
        {
            int mid = low + (high -low) / 2 ;
            int distL = low - arr[mid] ;
            int distH = arr[mid + k ] - x ;
            if (distL > distH){
                low = mid + 1 ;
            }else{
                high = mid ;
            }

        }for ( int i = low ; i < low + k ; i ++){
            result.add(arr[i]);
            
        }return result ;
    }
}