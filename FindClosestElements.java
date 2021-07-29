// Time Complexity : O(n - k)
// Space Complexity : O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int h = arr.length - 1 - k;
        int m = 0;
        while(l <= h){
            m = l + (h - l) / 2;
            int diffL = x - arr[m];
            int diffH = arr[m + k] - x;
            
            if(diffL > diffH)
                l = m + 1;
            else
                h = m - 1;
        }
        
        for(int i = l; i < l + k; i++)
            result.add(arr[i]);
        
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int h = arr.length - 1;
        
        while(h - l + 1 != k){
            int diffL = x - arr[l];
            int diffH = arr[h] - x;
            
            if(diffL > diffH)
                l++;
            else
                h--;
        }
        
        for(int i = l; i <= h; i++)
            result.add(arr[i]);
        
        return result;
    }
}