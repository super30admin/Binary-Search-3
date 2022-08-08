TC-0(LOG(N-K))+O(K)
SC-O(K)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        // multimap<int,int> m;
        // for(int i=0;i<arr.size();i++){
        //     m.insert({abs(x-arr[i]),i});
        // }
        // vector<int> res;
        // int count=0;
        // for(auto it=m.begin();count<k;it++,count++){
        //     res.push_back(arr[it->second]);
        // }
        // sort(res.begin(),res.end());
        // return res;
        int low=0;
        int high=arr.size()-k;
        while(low<high){
            int mid=low+(high-low)/2;cout<<mid;
            int leftside=x-arr[mid];cout<<leftside;
            int rightside=arr[mid+k]-x;cout<<rightside;
            if(leftside>rightside){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        vector<int>res(arr.begin()+low,arr.begin()+low+k);
        return res;
    }
};