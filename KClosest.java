// Time-  O(logn)
//  Space - O(1)   
class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = nums.length-k;
        while(low<high){
            int mid = low +(high-low)/2;
            int sl = x -nums[mid];
            int hl = nums[mid+k] -x;
            if(sl > hl){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        for(int i =low ; i< low+k; i++){
            result.add(nums[i]);
        }
        return result;
    }
}