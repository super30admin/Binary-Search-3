//TC => O(logn +k)
//SC ==> O(1)

public class Solution
{
    public IList<int> FindClosestElements(int[] arr, int k, int x)
    {
        IList<int> result = new List<int>();
        if (arr == null || arr.Length == 0)
        {
            return result;
        }
        int low = 0, high = arr.Length - k;

        while (low < high)
        {
            var mid = low + (high - low) / 2;
            var startDist = x - arr[mid];
            var endDist = arr[mid + k] - x;
            if (startDist > endDist)
            {
                low = mid + 1;
                // break;
            }
            else
            {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++)
        {
            result.Add(arr[i]);
        }
        return result;
    }
}