class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue< pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        vector<int> answer;
        for (int i=0;i<arr.size();i++) {
            pq.push({abs(arr[i]-x),arr[i]});
        }
        int count=0;
        while (count<k) {
            auto x=pq.top();
            pq.pop();
            cout<<x.first<<" "<<x.second<<endl;
            answer.push_back(x.second);
            count++;
        }
        sort(answer.begin(),answer.end());
        return answer;
    }
};