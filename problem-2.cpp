// t-c: n
// s-c: 1
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int l = 0, h = arr.size()-1;
        vector<int> ans;
        while(abs(l - h) >= k)
        {
            if(abs(x-arr[l]) > abs(x-arr[h]))
                l++;
            else
                h--;
        }
        for(int i = l; i <= h; i++)
        {
            ans.push_back(arr[i]);
        }
        return ans;
    }
};
