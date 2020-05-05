// Time Complexity - O(log(n-k))
// Space Complexity - O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length-k;

        while(left < right){

            int mid = (left+right)>>1;

            if(Math.abs(arr[mid]-x) > Math.abs(arr[mid+k] - x)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return Arrays.stream(arr,left, left+k).boxed().collect(Collectors.toList());
    }
}