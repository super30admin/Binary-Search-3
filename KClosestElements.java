package BinarySearch3;

import java.util.ArrayList;
import java.util.List;

/*-----------------------
Time complexity : o(n-k) with two pointers o(log n-k) with binary search
space complexity: o(1)
Did this code run successfully in leetcode : yes
problems faces : no*/
                
public class KClosestElements {
    
  public List<Integer> findClosestElementsWithTwoPointers(int[] arr, int k, int x) {
      
      List<Integer> result = new ArrayList<>();
      
      if(arr == null || arr.length == 0) return result;
      
     int low = 0;
     int high = arr.length-1;
     
     while(high -low +1 > k)
     {
         int lowDistance = Math.abs(arr[low]-x);
         int highDistance = Math.abs(arr[high] -x);
         
         if(lowDistance <= highDistance)
         {
             high--;
         }
         else
         {
             low++;
         }
     }
     
     for(int i=low;i<=high;i++)
     {
         result.add(arr[i]);
     }
     
      
      return result;
        
    }
  
  public List<Integer> findClosestElementsWithBinarySearch(int[] arr, int k, int x) {
      
      List<Integer> result = new ArrayList<>();
      
      if(arr == null || arr.length == 0) return result;
      
     int low = 0;
     int high = arr.length-k;
     
     //binary search
     while(low<high)
     {
         
         int mid = low+(high-low)/2; 
         int distF =  x-arr[mid];
         int distL = arr[mid+k]-x;
         
         if(distF > distL)
         {
             low = mid+1;
         }
         else
         {
             high = mid;
         }
     }
     
     for(int i=low;i<low+k;i++)
     {
         result.add(arr[i]);
     }
     
      
      return result;
        
    }


}
