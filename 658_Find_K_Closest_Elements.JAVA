    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/find-k-closest-elements/
    Time Complexity for operators : o(logn) .. n is the length of the string
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Deduct x from all element of arr. Then just sort it and return first k. Need to make tuple
                            in order to keep track of elememnt with different with x.
        # Optimized approach: 
                              
            # 1. 
                    A) With binary search, left will be at left side and right will be at arr.length-k position
                    B) n while loop, first we will calculate mid and thne check for left_bound and right_bound
                    C) we will use value of left and right bound to move left and right pointers
                    D) if left_bound is greater then make left  to mid+1 that means these elements are far aways from x
                    E) else go to right_bound. There will be one corner case for this that w e need to check.
                            if(arr[mid]==arr[mid+k]) then we need to move our left to mid+1
                            else right = mid;
                    F) At the end, we are the starting point from which we need to return k element.
                    E) Create a list and add k elements from left position to it.
                    F_ At the end, return  the list.
    */  

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        if(arr.length == 0)
            return new ArrayList<>();
        
        int left = 0;
        int right = arr.length-k;
        
        while(left<right){
            int mid = left + (right-left)/2;
            
            int left_bound = Math.abs(x-arr[mid]);
            int right_bound = Math.abs(x-arr[mid+k]);
            
            if(left_bound>right_bound){
                left = mid + 1;
            }else{
                
                // take care of this. corner case only failed for one  test case
                
                if(arr[mid] == arr[mid+k]){
                    left = mid+1;
                }else{
                    right = mid;   
                }                    
            }
        }
            
        List<Integer> result = new ArrayList<>();
        
        for(int i=left;i<left+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}