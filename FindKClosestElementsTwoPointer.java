// TC: O(n)
// SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0) {
            return res;
        }
        int low, high;
        low = 0;
        high = arr.length - 1;
        while(high - low + 1 > k) {
            int distF = x - arr[low];
            int distL = arr[high] - x;
            if(distF > distL) {
                low++;
            } else {
                high--;
            }
        }
        for(int i = low; i <= high; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}