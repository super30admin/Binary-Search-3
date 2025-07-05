//Time Complexity : O(n-k)
//Space Complexity : O(k)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low = 0, high = arr.size() - 1;
        while(high-low >= k )
        {
            if(x-arr[low] > arr[high]-x)
                low++;
            else
                high--;
        } 
        return vector<int> (arr.begin()+low, arr.begin()+low+k);
    }
};