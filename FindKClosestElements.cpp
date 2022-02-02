//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low =0;
        int high=arr.size()-1;
        vector<int> result;
        while(high-low>=k)
        {
            if(abs(arr[high]-x)>=abs(arr[low]-x))
            {
                high--;
            }
            else
            {
                low++;
            }
        }
        
        for(int i=low;i<=high;i++)
        {
            result.push_back(arr[i]);
        }
        return result;
    }
};