// time complexity for 2 pointer - O(n), for binary search - O(logn)
// space - O(1)
public class Solution
{
    public IList<int> FindClosestElements(int[] arr, int k, int x)
    {
        IList<int> res = new List<int>();
        if (arr == null || arr.Length == 0)
        {
            return res;
        }
        // binary search
        int low = 0;
        int high = arr.Length - k;
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distR = arr[mid + k] - x;


            if (distL > distR)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++)
        {
            res.Add(arr[i]);
        }
        // two pointer approach
        // int start = 0;
        // int end = arr.Length -1;

        // while((end-start) >=k )
        // {
        //     if(Math.Abs(arr[start]-x) > Math.Abs(arr[end]-x))
        //     {
        //         start++;
        //     }
        //     else
        //     {
        //         end--;
        //     }
        // }

        // for(int i=start;i<=end;i++)
        // {
        //     res.Add(arr[i]);

        // }
        return res;
    }
}