//Time Complexity-O(logn)
//Space Complexity-O(1)
//Did the code run on Leetcode? Yes

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int>res={};
        if(arr.size()==0)
        {
            return res;
        }
        int low=0;
        int high=arr.size()-k;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int a=abs(arr[mid]-x);
            int b=abs(arr[mid+k]-x);
            if(a>b)
            {
                low=mid+1;
            }
            else
            {
                high=mid;
            }
        }
        for(int i=low;i<low+k;i++)
        {
            res.push_back(arr[i]);
        }
        return res;
    }
};