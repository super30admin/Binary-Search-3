import java.util.ArrayList;
import java.util.List;

class Solution {
	//Approach: 1. The low and high pointers are placed on the left most and k element from right most positions in the array. 
	//Then I have calculated the mid value and distL, distR are calculate with absolute difference with x, moving low and high accordingly, we iterate till low is less than high.
	//2. This way we will stop when there are k elements between left and right pointers.    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        int low = 0, high = arr.length - k;
        while(low < high)
        {
            int mid = low + (high-low)/2;
            int distL = Math.abs(x - arr[mid]);
            int distR = Math.abs(x - arr[mid+k]);
            if( distL > distR )
                low = mid + 1;
            else
            {
                if(arr[mid] == arr[mid+k])
                    low = mid + 1;
                else
                    high--;
            }  
        }
        
        for(int i=low;i < low + k; i++ )
        {
            result.add(arr[i]);
        }
        return result;
    }
}
//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: 1. The low and high pointers are placed on the left most and right most positions in the array. Then I have calculated the value at left pointer's absolute difference 
//with x and meanwhile right pointer value's absolute difference with x, if distL is higher we move low pointer else high pointer.
//2. This way we will stop when there are k elements between left and right pointers.

class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        int low = 0, high = arr.length - 1;
        while(high - low + 1 > k)
        {
            int distanceOfLow = Math.abs(x - arr[low]);
            int distanceOfHigh = Math.abs(x - arr[high]);
            //System.out.println(low+"--"+high);
            if(distanceOfLow > distanceOfHigh)
            {
                low++;
            }                
            else
            {
            	high--;
            }   
        }
        
        for(int i=low;i < low + k; i++ )
        {
            result.add(arr[i]);
        }
        return result;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :