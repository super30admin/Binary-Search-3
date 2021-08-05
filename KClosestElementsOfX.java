//Time Complexity:O(log(n-k) + k) ; n is no of elements in array
//Space Complexity: O(1);
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int low =0,high= arr.length - k;
        while(low<high){
            int mid = low + (high-low)/2;
            int lowdist = x- arr[mid];
            int highdist = arr[mid+k] - x;
            if(lowdist>highdist){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}