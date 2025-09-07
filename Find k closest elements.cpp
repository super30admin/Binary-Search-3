class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low =0;
        int high = n-k;
        while(low<high) // find 1st element of K using binary search (low)
        {
            int mid = low+(high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
             if (distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        vector<int> result; // from low push low +k elements 
        for (int i = low; i < low + k; i++) {
            result.push_back(arr[i]);
        }

        return result;
    }
};