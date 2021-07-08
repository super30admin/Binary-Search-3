// Time Complexity : O(logn + k)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int l = 0;
        int h = arr.size()-1;
        int m;
        vector<int> ret_vect;
        
        while(l < h)
        {
            m = l + floor((h-l)/2);
            
            if(arr[m] == x)
            {
                l = m;
                break;
            }
            // Second half
            else if(arr[m] < x)
                l = m+1;
            // First half
            else
                h = m;
        }
        
        
        int lptr = l-1;
        int hptr = l;
        
        int nl, nh;
        
        for(int i = 0; i < k; i++)
        {
            if(lptr >= 0 && lptr < arr.size())
                nl = abs(x - arr[lptr]);
            else
                nl = INT_MAX;
            
            if(hptr >= 0 && hptr < arr.size())
                nh = abs(x - arr[hptr]);
            else
                nh = INT_MAX;
            
            if(nl <= nh)
            {
                ret_vect.push_back(arr[lptr]);
                lptr--;
            }
            else
            {
                ret_vect.push_back(arr[hptr]);
                hptr++;
            }   
        }
        
        sort(ret_vect.begin(), ret_vect.end());
        return ret_vect;
    }
};