//Time Complexity: o(k) + O(logn) & in worst case its O(n)
//Space Complexity: O(k) & O(n) in worst case


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        if(arr.length ==0 || arr == null)
            return result;
        
        int low = 0;
        int high = arr.length -k;
        
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(Math.abs(arr[mid] - x) > Math.abs(arr[mid+k] -x))
            {
                low = mid + 1;
            }else
            {
                high = mid;
            }
        }
        
        for(int i=0; i<k; i++)
            result.add(arr[low+i]);
        
        return result;
    }
    
}
