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
