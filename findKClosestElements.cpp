//time complexity:O(nlogn)
//space complexity:O(k)
//executed on leetcode: yes
//approach:using binary search
//any issues faced? yes

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int right=lower_bound(arr.begin(),arr.end(),x)-arr.begin();
        int left=right-1;
        vector<int>res;
        while(k--)
        {
            if(left>=0 && abs(arr[left]-x) <= abs(arr[right]-x))
            {
                res.push_back(arr[left]);
                left--;
            }
            else
            {
                res.push_back(arr[right]);
                right++;
            }
        }
        sort(res.begin(),res.end());
        return res;
    }
};