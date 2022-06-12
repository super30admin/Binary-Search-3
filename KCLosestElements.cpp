USING 2 POINTERS  = O(N-K) time, O(1) space

O(N-K) time, O(1) space

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        int left = 0;
        int right = arr.size()-1;
        while(right-left+1>k){
            int leftDiff = abs(x - arr[left]);
            int rightDiff = abs(x - arr[right]);
            if(leftDiff>rightDiff) left++;
            else right--;
        }
        while(k>0){
            result.push_back(arr[left]);
            left++;
            k--;
        }
        return result;
    }
};

TC = O(log(N-k)) + O(k)
SC = O(1)
    
class Solution {
public:
    vector<int> findClosestElements(vector<int>& nums, int k, int x) {
        vector<int> result;
        int left = 0;
        int right = nums.size()-k;
        while(left<right){
            int mid = left + (right-left)/2;
            int distLeft = x - nums[mid];
            int distRight = nums[mid+k] - x; //checking an extra
            if(distLeft <= distRight)
                right = mid;
            else 
                left = mid + 1;
        }
        while(k>0){
            result.push_back(nums[left]);
            left++; k--;
        }
        return result;
    }
};

// distL <= distR => because if distances are same- we move towards lesser element
// We dont take abs distances - because if distances are same around middle, then I am reducing right search space - which is incorrect. 
//example
// [1,1,2,2,2,2,2,3,3]
// 3
// 3
