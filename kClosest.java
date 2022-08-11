//Time Complexity:O(n)
//Space Complexity: O(1).


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x)  {   
        if(arr == null || arr.length == 0) return new ArrayList<Integer>();
        
        int left = 0;
        int right = arr.length-1;
        
        while(right - left + 1 > k){
            int leftdist = x - arr[left];
            int rightdist = arr[right] - x;
            
            if(leftdist > rightdist){
                left++;
            }
            else
            {
                right--;
            }
            
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++)
            result.add(arr[i]);
        
        return result;
    }
}