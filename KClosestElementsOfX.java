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

//Solution 2
//Time Complexity:O(n) ; n is no of elements in array
//Space Complexity: O(1);
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int low =0,high= arr.length - 1;
        while(high-low+1 > k){

            int lowdist = Math.abs(arr[low] - x);
            int highdist = Math.abs(arr[high] - x);
            if(lowdist>highdist){
                low++;
            }else{
                high--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}