// 1. dist arr, sort, min k dists - nlogn
// 2. dist arr, heap, min k dists - nlogk
// 3. dist arr, sliding window when we find the min ele - n
// 4. 2 ptrs on og arr, comparing dists - n-k
// 5. binary search for lower bound - logn
// 6. binary search on the start of range - log(n-k) (BELOW SOLN)
//time: O(log(n-k)) + O(k)
//space: O(1)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low = 0;
        int high = n-k;
        while(low < high) {
            int mid = low + (high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        vector<int> result;
        for(int i = low; i < low+k; i++) {
            result.push_back(arr[i]);
        }
        return result;
    }
};