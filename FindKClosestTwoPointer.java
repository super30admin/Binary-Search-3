// two pointer solution.
// space complexity = O(1)
// time complexity = O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low =0;
        int high = arr.length-1;
        while(high-low + 1 >k) {
            int intA = Math.abs(arr[low] - x);
            int intB = Math.abs(arr[high] - x);
            if(intA<= intB) {
                high--;
            } else {
                low++;
            }
        }
        for(int i=low;i<= high;i++) {
            res.add(arr[i]);
        }
        return res;
        
    }
}