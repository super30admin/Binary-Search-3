//time O(n)
//space O(1)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> rs;
        int left = 0;
        int right = arr.size()-1;

        while(right-left+1>k){
            int distL = abs(x-arr[left]);
            int distR = abs(x-arr[right]);

            if(distL >distR){
                left++;

            }
            else{
                right--;
            }
        }

        for(int i=left;i<=right;i++){
            rs.push_back(arr[i]);
        }

        return rs;



        
    }
};