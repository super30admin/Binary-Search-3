//time - O(log(n-k)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size()-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int start_dist = x-arr[mid];
            int end_dist = arr[mid+k]-x;
            if(start_dist > end_dist){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        vector<int> result;
        for(int i=low;i<low+k;i++){
            result.push_back(arr[i]);
        }
    return result;
        
    }
};



class Solution {
public: 
      vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //priority queue Solution
        //time - O(nlogk)
         auto comp = [&x](const pair<int, int>& a, const pair<int, int>& b) {
            if (a.second == b.second) return a.first < b.first;
            return a.second < b.second;
        };

        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(comp)> pq(comp); // num, distance
        for(int i=0;i<arr.size();i++){
            int dist = abs(arr[i]-x);
            pq.push({arr[i], dist}); //nlogk
            if(pq.size()>k){
                pq.pop();
            }
        }
    vector<int> result;
    while(!pq.empty()){
        pair<int, int> popped = pq.top();
        result.push_back(popped.first);
        pq.pop();
    }
    sort(result.begin(), result.end()); //klogk
    return result;
    }
};
//Two Pointer Approach Time - O(n)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int left = 0;
        int right = arr.size()-1;
        while(right-left>=k){
            int left_dist = abs(arr[left]-x);
            int right_dist = abs(arr[right]-x);
            if(left_dist>right_dist){
                left++;
            }
            else{
                right--;
            }
        }
        vector<int> result;
        for(int i=left;i<=right;i++){
            result.push_back(arr[i]);
        }
return result;
        
    }
};
