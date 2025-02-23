/*
TC : O(log n-k) + O(k)
SC : O(1)
*/
class Solution
{
public:
    vector<int> findClosestElements(vector<int> &arr, int k, int x)
    {
        if (arr.size() == 0 || arr.empty())
        {
            return {};
        }

        int low = 0, high = arr.size() - k;

        while (low < high)
        {
            int mid = low + (high - low) / 2;
            int left = x - arr[mid];
            int right = arr[mid + k] - x;
            if (left > right)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }

        vector<int> result;
        for (int i = low; i < low + k; i++)
        {
            result.push_back(arr[i]);
        }

        return result;
    }
};