// **TC : O(n) → while loop will run till (n-k) & we iterate on those remaining k terms to give the result so n-k+k = n**

// **SC: O(1)**
class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        
        int low = 0;
        int high = n-1; 
        while(high - low + 1 > k){
            if(Math.abs(x - nums[low]) > Math.abs(x - nums[high])){
                low++;
            }else{ //word for less than equal to cases
                high--;
            }
        
        }    
        for(int i=low; i<=high;i++){
            result.add(nums[i]);
        }
        return result;
    }
}
