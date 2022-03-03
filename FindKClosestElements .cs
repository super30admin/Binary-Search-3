//https://leetcode.com/submissions/detail/652299807/
Time: O(k)
Space: O(1)

public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        List<int> result = new List<int>();
        
        if(arr == null || arr.Length == 0) {
            return result;
        } 
        
        int low = 0;
        int high = arr.Length - 1;
        
        while(high - low + 1 > k) {
            int distL = Math.Abs(arr[low] - x);
            int distR = Math.Abs(arr[high] - x);
            
            if(distL > distR) {
                low++;
            } else {
                high--;
            }
        }
        
        for(int i = low; i < low + k; i++){
            result.Add(arr[i]);
        }
        return result;
    }
}