Time Complexity : o(log(n))
Space Complexity: o(1)
class Solution {
    LinkedList<Integer> result;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        result = new LinkedList<>();
        if(arr.length == 0 || arr.length < k) return result;
        int closest = binarySearch(arr, x);
        result.add(arr[closest]);
        k--;
        int low = closest -1;int high = closest+1;
        while(k>0)
        {
            if(low < 0)
            {
                result.addLast(arr[high]);
                high++;
            }
            else if(high >= arr.length)
            {
                result.addFirst(arr[low]);
                low--;
            }
            else
            {
                if(x-arr[low] <= arr[high]-x)
                {
                    result.addFirst(arr[low]);
                    low--;
                }
                else
                {
                    result.addLast(arr[high]);
                    high++;
                }
            }
            k--;
        }
        return result;
    }
    private int binarySearch(int[] arr, int x)
    {
        int low = 0; int high = arr.length -1;
        while (low < high)
        {
            int mid = low + (high - low)/2;
            if (arr[mid] == x)
            {
                return mid;
            }
            else if(arr[mid] > x)
            {
                high = mid;
            }
            else
            {
                low = mid +1;
            }
        }
        if(low == 0) return low;
        else 
        {
            if (x-arr[low -1] <= arr[low] -x) return low-1;
            else 
                return low;
        }
        
    }
}