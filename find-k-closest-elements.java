class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while(right - left >= k){
            int distL = Math.abs(arr[left] - x);
            int distR = Math.abs(arr[right] - x);
            if(distL <= distR){
                right--;
            }else{
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}