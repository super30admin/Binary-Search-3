// TC: O(logN)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList();
        if ( arr == null || arr.length == 0)
            return result;
        int closest = binarySerach(arr, x);
        result.addFirst(arr[closest]);
        int left =  closest - 1;
        int right = closest + 1;
        while (k > 1)
        {
            if (left < 0)
            {
                result.addLast(arr[right]);
                right++;
            }
            else if (right == arr.length)
            {
                result.addFirst(arr[left]);
                left--;
            }
            else 
            {
                if (x - arr[left] > arr[right] - x)
                { 
                    result.addLast(arr[right]);
                    right++;
                }
                else
                {
                    result.addFirst(arr[left]);
                    left--;
                }
            }
            k--;
        }
        return result;
    }
    
    private int binarySerach(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length -1 ;
        while ( low < high)
        {
            int mid = low + (high - low ) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        if ( low == 0) return low;
        if (Math.abs(arr[low] - target) < Math.abs(arr[low-1] - target))  return low;
        return low - 1 ;
    }
}
