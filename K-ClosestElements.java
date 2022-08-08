import java.util.ArrayList;
import java.util.List;

//Time Complexity- O(log(n-k))
//Space Complexity- O(1)
//Successfully ran on leetcode

class Solution {
    
   
 public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
      //Binary search
     if(arr==null || arr.length == 0) return new ArrayList<>();
         int n= arr.length;
         int low= 0;
         int high= n-k;
         int mid=0;
     
     while(low< high){
         mid= low+ (high-low)/2;
        int distStart= x - arr[mid];
        int distEnd= arr[mid+k]- x;
         
         if(distStart > distEnd){
             low= mid+1;
         }
         else high= mid;
     }
     List<Integer> result= new ArrayList<>();
         for(int i=low ; i< low+k; i++){
             result.add(arr[i]);
         }
     return result;
     }
 }

