//Time complexity is O(N)
//Space complexity is O(1)
//This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN86KthClosestElement {
	    public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        // Two pointer solution
	        List<Integer> result = new ArrayList<>();
	        //edge
	        if(arr == null || arr.length ==0)
	            return result;
	        int low = 0;
	        int high = arr.length -1;
	        while(high-low +1 >k){
	            int disL = Math.abs(x- arr[low]); 
	            int disR = Math.abs(x- arr[high]);
	            if(disL>disR)
	                low++;
	            else
	                high--;
	        }
	        for(int i = low;i<=high;i++){
	            result.add(arr[i]);
	        }
	        return result;
	    }
	}