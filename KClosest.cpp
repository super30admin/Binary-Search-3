class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low = 0;
        int high =n-k;

        while(low<high)
        {
            int mid = low + (high-low)/2;

            int distS = (x - arr[mid]);
            int distE = (arr[mid+k] - x);

            if(distS > distE)
            {
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        vector<int> result;

        for(int i = low; i< low+k;i++)
        {
            result.push_back(arr[i]);
        }

        return result;
    }
};