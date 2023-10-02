class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> result;
        int n = arr.size();
        int left = 0;
        int right = n-k;

        while(left<right){
            int mid = left+(right-left)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k] - x;
            if(distS>distE){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }

      

        for(int i = left;i<left+k;i++){
            result.push_back(arr[i]);
        }

        return result;
    }
};

Time : log(n-k)


//   while((right-left+1)>k ){
//                 int distL = abs(arr[left]-x);
//                 int distR = abs(arr[right]-x);

//                 if(distL > distR){
//                     left++;
//                 }
//                 else{
//                     right--;
//                 }
    
//         }