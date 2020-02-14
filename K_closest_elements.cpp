//Time Complexity-O(n-k)-->O(n)
//Space Complexity-O(1)
// Did the code run on Leetcode? Yes

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int>res={};
        if(arr.size()==0)
        {
            return res;
        }
        int low=0;
        int high=arr.size()-1;
        while(high-low+1>k)
        {
            int a=abs(arr[low]-x);
            int b=abs(arr[high]-x);
            if(a>b)
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        for(int i=low;i<low+k;i++)
        {
            res.push_back(arr[i]);
        }
        return res;
    }
};