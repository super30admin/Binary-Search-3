// ran succussfully on leetcode: yes
class Solution {
    // space: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int low = 0, high = n - k;

        // Time: O(logn)
        while(low < high){
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        // Time: O(k)
        for(int i=low; i< low+k; i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}