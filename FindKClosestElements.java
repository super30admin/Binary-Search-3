// Time Complexity: O(log(n-k))
// Space Complexity: O(1)
// Run on leetcode: yes
// Issues Faced: high = n-k I was doing n-k-1 and mid = low + (high - low)/2 I was doing (low + (high - low))/2

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return res;
        int n = arr.length;
        int low = 0;
        int high = n-k;
        while(low < high){
            int mid = low + (high - low)/2;
            int dF = x - arr[mid];
            int dL = arr[mid+k] - x;
            if(dF > dL){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        for(int i=low; i<low+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
