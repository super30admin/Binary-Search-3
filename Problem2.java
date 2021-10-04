class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        List<Integer> result = new ArrayList<>();
        while(high - low + 1 > k)
        {
            int highDistance = Math.abs(arr[high] - x);
            int lowDistance = Math.abs(arr[low] - x);
            
            if(lowDistance > highDistance)
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        for(int i = low;i<= high;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}

// tc : O(n-k)
// sc: 0(1)