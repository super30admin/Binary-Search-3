// Time complexity O(logn)
// Space complexity O(1)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        // binary search for start indexc of the range of k elements.

        int n = arr.size();
        int lo = 0;
        int hi = n-k; 
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            
            int end = mid + k; // why not (k-1) ? 
            // consider [1, 2, 3, 4, 5] with k = 4 and x = 3. 

            int dista = x - arr[mid];
            int distb = arr[end] - x;

            if (dista > distb) { // tilted more towards the left side, update the left ptr i.e lo;
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        vector<int> res;
        for (int i = lo; i < (lo+k); i++)
        {
            res.push_back(arr[i]);
        }
        return res;
    }
};