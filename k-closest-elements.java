//time: O(k + log N)
//space: O(1)

class Solution {    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0; 
        int end = arr.length - k;
        
        while(start < end)
        {
            int mid = start + (end - start)/2;
            int start_bound = Math.abs(x - arr[mid]);
            int end_bound = Math.abs(arr[mid+k] - x);
            if (end_bound < start_bound)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid;
            }
        }
        
        for(int i = start; i < start + k; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}