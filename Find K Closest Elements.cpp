//Time Complexity- O(log(n-k)+k)
//Space Complexity- O(1)

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int low=0;
        int high=arr.size()-k;
        while(low<high){
            int mid=low+(high-low)/2;
            int diffs=x-arr[mid];
            int diffe=arr[mid+k]-x;
            if(diffs>diffe){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        
        vector<int> ans;
        for(int i=low;i<low+k;i++){
            ans.push_back(arr[i]);
        }
        return ans;
    }
};