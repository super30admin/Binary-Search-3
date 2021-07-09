// Time Complexity : O(log (n-k))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
 * 1. It is binary search approach to find the left pointer or starting index.
 * 2. on end pointer move to the k elements left to start as starting index starts at n-k.
 * 3. calculate distance to the given x and move pointer respectively. 
 * 4. copy k elements from the left pointer as a result.
 */

import java.util.ArrayList;
import java.util.List;

public class KClosestElementsBinarySearch {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        
	        List<Integer> result = new ArrayList<>();
	        if(arr==null || arr.length<1) return result;
	        
	        int leftp=0;
	        int rightp=arr.length-k;
	        
	            while(leftp<rightp){
	            	int mid= leftp+(rightp-leftp)/2;
	            	
	            	int leftd=x-arr[mid];
	                int rightd=arr[mid+k]-x;
	            
	                if(leftd>rightd){
	                    leftp=mid+1;
	                }else{
	                    rightp=mid;
	                }
	            }
	           
	        for(int i=leftp;i<leftp+k;i++){
	            result.add(arr[i]);
	        }
	        
	        return result;
	        
	    }
}
