// Approach - 1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr == null)
            return new ArrayList();
        
        int start = 0, end = arr.length - 1;
        
        while(start <= end) {
            if(k == end - start + 1)
                break;
            else if(Math.abs(arr[start] - x) <= Math.abs(arr[end] - x))
                end --;
            else 
                start++;
        }
        List<Integer> res = new ArrayList();
        for(int i = start; i < start + k; i++) {
            res.add(arr[i]);
        }
      return res;
    }
}

// Approach - 2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr == null)
            return new ArrayList();
        
        int left = 0, right = arr.length - k;
        
        while(left < right) {
            int start = left + (right - left) / 2;
            int end = start + k;
            
            if(x - arr[start] > arr[end] - x)
                left = start + 1;
            else
                right = start;            
        }
        
        List<Integer> res = new ArrayList();
        for(int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }     
        
      return res;
    }
}


 


   