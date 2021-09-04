/*
Time Complexity = O(N)
Space Complexity = O(1)
where N is the number of elements in array.
*/
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int l = 0 , r = arr.size()-1;
        while(r-l+1>k)
        {
            int distl = x - arr[l];
            int distr = arr[r] - x;
            if(distl>distr)
                l++;
            else
                r--;
        }
        vector<int> result;
        for(int i=l;i<=r;i++)
            result.push_back(arr[i]);
        return result;
    }
};
