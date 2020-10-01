// Time Complexity : O(log(n)) as we are dividing the search space always
// Space Complexity : O(1) as we are not creating any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int l = 0;
        
        int r = arr.size() -k; // setting the left and right bounds
        
        
        while(l <r){
            
            
            int mid = l + (r - l)/2 ;                
            int left_len = abs(x - arr[mid]);
            int right_len = abs(x - arr[mid + k]); // calculating the absolute difference for the values for comparision
            
            if(right_len < left_len){
                l = mid +1; // if the right is nearest then we move to the right half part
            } else{
                if(arr[mid] == arr[mid +k])
                    l = mid +1; // in case of the values where both the values are same we will move right
                else
                    r = mid; // else moving to left half part
            }
        }
        // now we have the starting of our array output at the index l
        // so we just have to return the k values starting from index l
        vector<int> result;
        
        for (int i = l; i < l+k; i++){
            result.push_back(arr[i]); 
        }
        
        return result;
    }
    
    
    
};