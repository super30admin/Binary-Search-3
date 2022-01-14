// 658 Find K Closest Elements
// solved on Leetcode
// Time Complexity : log(n-k)
// Space Complexity : O(1)


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int start = 0;
        int end = arr.length - k;
        
        while(start <= end){
            
            int mid = start + (end - start)/2;
            int diff1 = x - arr[mid];
            int diff2;
            if(mid + k >= arr.length){
                 diff2 = Integer.MAX_VALUE;
            }else{
                 diff2  = arr[mid + k] - x;
            }
            
            if(diff1 > diff2){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            
        }
        
        ArrayList<Integer> result = new ArrayList();
        for(int i = start ; i < start + k; i ++){
            result.add(arr[i]);
        }
        
        return result;
    }
}