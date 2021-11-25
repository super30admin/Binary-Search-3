import java.io.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Create a result as ArrayList 
        ArrayList<Integer> result = new ArrayList<>();
        
        // if no element , return empty list
        if(arr.length == 0){
            return result;
        }
        
        // Declare all the variables 
        int low = 0;
        int high = arr.length - k;
        int mid, distS, distE;
        
        
        // Do the binary search to find the starting point of the range
        // Binary search must be done on the n-k elements 
        // as the size of the elements we need in the window is k.
        while(low < high){
        
            mid = low + (high - low)/ 2;
            distS = x -  arr[mid];
            distE =  arr[mid + k] - x;
        
            if (distS > distE){
                low = mid + 1;
            }
            else{
                high = mid;
            }
            
        }
        
        // In Binary search , low index maps to the starting point
        // Traverse through the low to low+k for the k closest elements
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        
        return result;
        
        
    }
}