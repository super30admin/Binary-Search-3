/*
 * #658. Find K Closest Elements
 * 
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1. 1 <= k <= arr.length
2. 1 <= arr.length <= 10^4
3. Absolute value of elements in the array and x will not exceed 104

 */


/*
 * Time Complexity: O (log N) -> Binary Search on sorted array
 * 
 * Space Complexity: O (1) -> No extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.binarysearch3;

import java.util.ArrayList;
import java.util.List;

public class KElementsClosestToX {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        
	        // #1. Create an output list
	        List<Integer> output = new ArrayList<>();
	        
	        // #2. Base Condition
	        if(arr == null || arr.length == 0){
	            return output; // return empty ArrayList
	        }
	        
	        // #3. Initialize the low and high pointer for Binary Search
	        // Intuition: Since, we are given a sorted array, Binary Search can be implemented
	        int low = 0;
	        int high = arr.length - k; // Doing this, as it guarantees that array will not go out of bounds when we do arr[mid+k] while calculating right_bound
	        
	        // #4. Start Binary Search
	        /*
	        * 1. Calculate the mid
	        * 2. Compute the left bound
	        * 3. Compute the right bound
	        * 4. Check if leftBound > rightBound
	        *       - If yes, then we can go to right side of midpoint to find our starting point and traverse starting point + k steps to get k closest elements to x -> low = mid + 1
	        *       - If not, we handle two conditions in else block
	        *           - what if arr[mid] == arr[mid+k], meaning left and right bounds are equal, then go to right side, low = mid+1
	        *           - If leftBound < rightBound, go to left side of midpoint to find our starting point and traverse starting point + k steps to get k closest elements to x -> high = mid, we are not doing high = mid-1 because we will skip the mid element to be in consideration for a starting point and this might fail for few cases, so high = mid;
	        * 5. After finding our starting point, go starting point + k steps to find the k elements closest to x and add each element from starting point to startingPoint + k to a list
	        * 6. Return the list as output 
	        */
	        
	        while(low < high){
	            int mid = low + (high - low) / 2;
	            
	            int leftBound = Math.abs(x - arr[mid]);
	            int rightBound = Math.abs(x - arr[mid+k]);
	            
	            if(leftBound > rightBound){
	                low = mid + 1;
	            }else{
	                if(arr[mid] == arr[mid+k]){
	                    low = mid + 1;
	                }
	                else{
	                    high = mid;
	                }
	            }
	            
	        }
	        
	        // #5. Got our starting point, now get starting point + k elements and add to output list
	        for(int i = low; i < low + k; i++){
	            output.add(arr[i]);
	        }
	        
	     // #6.  return the output
	        return output; 
	        
	    }
	    
}
