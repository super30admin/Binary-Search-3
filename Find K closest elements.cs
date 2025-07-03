/*
  Time complexity: O((log n) + k)
  Space complexity: O(1)

*/

public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        int mid = BinarySearch(arr,x);
        int low = Math.Max(0,mid-k);
        int high = Math.Min(mid+k,arr.Length-1);

        while(high-low>=k)
        {
            if(Math.Abs(x-arr[low])<=Math.Abs(x-arr[high]))
            {
                high--;
            }
            else 
            {
                low++;
            }
        }
        return arr[low..(high+1)];
    }
    private int BinarySearch(int[] arr, int target)
    {
        int low = 0;
        int mid = 0;
        int high = arr.Length-1;
        while(low<=high)
        {
            mid = low + (high-low)/2;
            if(arr[mid]==target)
                return mid;
            else
            {
                if(target<arr[mid])
                    high=mid-1;
                else
                    low = mid+1;
            }
        }
        return mid;
    }
}
