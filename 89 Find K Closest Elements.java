// Time Complexity : 0(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length-1;
        while(high - low + 1 > k )
        {
            int distF = Math.abs(arr[low] - x);
            int distL = Math.abs(arr[high] - x);

            if(distF > distL)
            {
                low++;
            }
            else
            high--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i<=high ;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}