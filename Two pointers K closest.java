// Time complexity - 0(n)
// space complexity - 0(1)
//code successfully executed on leetcode

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low =0;
        int high = arr.length-1;
        while(high-low + 1 >k){
            int L = Math.abs(arr[low]-x);
            int R = Math.abs(arr[high]-x);
            if(L>R){
                low++;
            } else {
                high--;
            }
        }
        for(int i=0; i < low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}