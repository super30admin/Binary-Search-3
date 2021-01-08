/*
Time COmplexity : O(log(arr.length) + k)
Space COmplexity : O(1)
Binary Search on range of k with smallest difference mid+kth element and x;
*/


class Solution1 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(x-arr[mid] <= arr[mid+k]-x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
/* 
Time Complexity : O(N)
Space COmplexity : O(1)
Idea : Two Pointer search to find a range of K.
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length-1;
        while(h-l+1>k){
            if(Math.abs(arr[l]-x) > Math.abs(arr[h]-x)){
                l++;
            }else{
                h--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(l!=h+1){
            ans.add(arr[l++]);
        }
        return ans;
    }
}