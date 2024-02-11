class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int left = 0,right = arr.size()- k -1,mid;
        vector<int> result;
        while(left <= right){
          mid = left + (right - left) / 2;
          if(x - arr[mid] > arr[mid+k] - x){
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        for(int i = 0; i<k;i++){
          result.push_back(arr[left+i]);
        }
        return result;
    }
};
