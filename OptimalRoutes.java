/*package whatever //do not write package name here */

/*
 * Time complexity : O(n log m)
 * Space complexity : O(1)
 */
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		int maxDistance = 7000;
		int[][] forwardRoutes = {{1, 2000}, {2, 4000}, {3, 6000}};
		int[][] backRoutes = {{1, 2000}};
		
	    int[] result = findOptimalRoutes(7000, forwardRoutes, backRoutes);
	    System.out.println(result[0] + " : "+ result[1]);
		
	}
	
	private static int[] findOptimalRoutes(int maxDistance, int[][] forwardRoutes, int[][] backRoutes){
	    
	    int max = 0;
	    int[] result = new int[2];
	    
	    for(int frd[] : forwardRoutes){
	        int target = maxDistance - frd[1];
	        int index = applyBinarySearch(backRoutes, target);
	        
	        if(index != -1){
	            int sum = frd[1] + backRoutes[index][1];
	            
	            if(sum > max){
	                max = sum;
	                result = new int[]{frd[1], backRoutes[index][1]};
	            }
	        }
	    }
	    
	    return result;
	   
	    
	}
	
	private static int applyBinarySearch(int[][] arr, int target){
	    
	    int low = 0;
	    int high = arr.length-1; 
	    
	    while(low <= high){
	        int mid = low + (high - low)/2;
	        
	        if(arr[mid][1] == target){
	            return mid;
	        } else if(arr[mid][1] > target){
	            low = mid + 1;
	        }else{
	            high = mid - 1;
	        }
	    }
	    
	    return high;
	}
}