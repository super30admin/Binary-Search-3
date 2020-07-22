// Time Complexity : O(NlogK)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//This problem is solved using min heap. Due to c++ constraint resultant array was sorted

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        auto cmp = [](const pair<int,int> a, const pair<int,int> b)
        {
            if(a.first == b.first) return a.second > b.second;
            else return a.first > b.first;
        };
        if(k==arr.size()) return arr;
        priority_queue<pair<int,int>, vector<pair<int,int>>, decltype(cmp)> q(cmp);

        for(int i=0;i<arr.size();i++){
            int diff = abs(arr[i] - x);
            q.push(make_pair(diff,arr[i]));
        }
        vector<int> res;
        for(int i=0;i<k;i++){
           res.push_back(q.top().second);
            q.pop();
        }
        sort(res.begin(),res.end());
        return res;

    }
};
