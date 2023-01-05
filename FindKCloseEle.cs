// Time Complexity : O(n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes


public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        var res = new List<int>();
        var low = 0;
        var high = arr.Length -1;
        while(high - low >= k){
            int distL = Math.Abs(arr[low] - x);
            int distH = Math.Abs(arr[high] - x);
            if(distL > distH) low++;
            else high--;
        }
        for(int i = low; i <= high; i++){
            res.Add(arr[i]);
        }
        return res;
    }
}
