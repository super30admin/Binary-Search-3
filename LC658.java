//Time Complexity : O(Log(n-k))
//Space Complexity : O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        int low = 0;
        int high = arr.length - k;
        
        while(low<high)
        {
            int mid = low + (high-low)/2;
            
            int first = x - arr[mid];
            int second = arr[mid+k] - x;
            
            if(first > second)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=low;i<low+k;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}