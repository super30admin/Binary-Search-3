// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr.length == 0 || arr == null)
            return result;
        
        int low = 0, high = arr.length-1;
        while(high - low + 1 > k) {
            int distleft = x - arr[low];
            int distright = arr[high] - x;
            if(distleft > distright)
                low++;
            else
                high--;
        }
        for(int i=low; i < low+k; i++)
            result.add(arr[i]);
        return result;
    }
}