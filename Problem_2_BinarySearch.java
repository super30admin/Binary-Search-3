// Time complexity - O(logn)
// Space complexity - O(1)

// Binary search solution for without duplicates.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            int mid = low + (high-low)/2;
            int distL = Math.abs(x - arr[mid]);
            int distR = Math.abs(x - arr[mid+k]);
            if(distL > distR){
                low++;
            }else{
                high--;
            }
        }
        for(int i = low; i < low + k; i++ ){
            result.add(arr[i]);
        }
        Collections.sort(result);
        return result;
    }
}
