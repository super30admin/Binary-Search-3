//Time complexity O(log(n))
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        
        
        while(left < right){
            
            int mid = left + (right - left)/2;
            
            int leftDist = x - arr[mid];
            int rightDist =   arr[mid + k] - x;
            
            if(leftDist > rightDist){
                
                left = mid + 1;
            }
            
            else {
                
                right = mid;
            }
        }
        
      //  int[] result = new int[k];
        
        for(int i = 0; i < k; i ++){
            
          // System.out.println(left);
            result.add(arr[left]);
            left ++;
            
        } 
        
        return result;
        
    }
}