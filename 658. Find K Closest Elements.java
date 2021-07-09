class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    // two pointers 
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        // we neee pay attention to the "="
        while(right - left >= k){
            int lVal = Math.abs(arr[left] - x);
            int rVal = Math.abs(arr[right] - x);
            // if lVal is greater than the right one, we need move 
            // left pointer to shink the arrange
            if(lVal > rVal){
                left++;
            }else{
                right--;
            }
        }
        // we need pay attention to the "="
        for(int i = left; i <= right; i++){
            res.add(arr[i]);
        }
        return res;
    }
    // priority queue 
}