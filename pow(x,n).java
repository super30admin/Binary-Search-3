/**

arr = [1,2,3,4,5], k = 4, x = 4

find a target.


start = 0;
end = 4

mid = 0 + (4-0) / 2 = 2 is at 3.

O(log(N) + k)

arr = [1,2,3,4,5], k = 4, x = -1

**/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int targetIndex = binarySearch(arr, x);
        
        List<Integer> result = new ArrayList<>();
        int left = targetIndex - 1;
        int right = targetIndex;
        
        if (targetIndex == -1)
        {
            if ( x < arr[0])
            {
                left = 0;
                right = k - 1;
            }
            else
            {
                right = arr.length - 1;
                left = right - k + 1;
            }
        }
        else
        {
            while(right - left - 1 < k)
            {
                if (left == -1)
                {
                    right += 1;
                }
                
                if (Math.abs(x - arr[left]) > Math.abs(x - arr[right]))
                {
                    right++;
                }
                else
                {
                    left--;
                }
            }
        }
         
        for (int i=left; i<=right; i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
    
    private int binarySearch(int arr[], int x)
    {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end)
        {
            int mid = start + (end-start) / 2;
            
            if (arr[mid] == x)
            {
                return mid;
            }
            
            if (x > arr[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
            
        }
        
        return -1;  
    }
    
}
