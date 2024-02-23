// TC = O(log(N - K) + K)
// SC = O(1), find the start index of the range using BS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        // TC = O(NLogK), SC = O(K)
        
        // IMP: Creating a heap

        // auto compare = [&](int a, int b) {
        //     if (abs(a - x) == abs(b - x)) {
        //         return a < b;
        //     }
        //     return abs(a - x) < abs(b - x);
        // };
        // priority_queue<int, vector<int>, decltype(compare)> pq(compare);

        // for (int num : arr) {
        //     pq.push(num);
        //     if (pq.size() > k) {
        //         pq.pop();
        //     }
        // }
        // vector<int> result;
        // while (!pq.empty()) {
        //     result.push_back(pq.top());
        //     pq.pop();
        // }
        // sort(result.begin(), result.end());
        // return result;

        // TC = O(n - k), SC = O(1), 2 pointer PREFERRED
    //     int l = 0, r = arr.size() - 1;
    //     while(r - l + 1 > k) {
    //         int distL = abs(arr[l] - x);
    //         int distR = abs(arr[r] - x);
    //         if(distL > distR) l++;
    //         else r--;
    //     }
    //     vector<int> result;
    //     for(int i = l; i <= r; i++) result.push_back(arr[i]);
    //     return result;
    // }

    // TC = O(log(N - K) + K), SC = O(1), find the start index of the range using BS
        int low = 0, high = arr.size() - k;
        while(low < high) { // taking extra element (k + 1)
            int mid = low + (high - low) / 2;
            int distStart = x - arr[mid];
            int distEnd = arr[mid + k] - x;
            if(distStart > distEnd) low = mid + 1;
            else high = mid; // high = mid (Here the extra is taken)
        }
        vector<int> result;
        // found the low (Starting Index), take k elements
        for(int i = low; i < low + k; i++) result.push_back(arr[i]);
        return result;
    }
};