//Time Complexity:O(n) n is the number of elements in arr
//Space Complexity:O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res= new ArrayList<>();
        int left=0,right=arr.length-1;
        while(right-left+1>k){
            if(x-arr[left]<=arr[right]-x) right--;
            else left++;
        }
        for(int i=left;i<=right;i++){
            res.add(arr[i]);
        }
        return res;
    }
}