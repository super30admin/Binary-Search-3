// Brute force
// Time Complexity -> O(n+k) + O(nlogn) - Is this correct?
// Space Complexity -> O(k)
// Problems Faced - No!
// It runs on Leetcode
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        priority_queue<vector<int>> pq;
        
        for(int i = 0; i < arr.size(); i++){
            pq.push({abs(x - arr[i]), arr[i]});
            if(pq.size() > k)
                pq.pop();
        }
        
        vector<int> answer;
        while(!pq.empty()){
            vector<int> pair = pq.top(); pq.pop();
            answer.push_back(pair[1]);
        }
        sort(answer.begin(), answer.end()); // O(nlogn)
        return answer;
    }
};

// 2-pointer solution
// Time Complexity -> O(n-k)
// Space Complexity -> O(k), answer vector of size 'k'
// Problems Faced - No!
// It runs on Leetcode
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int left = 0;
        int right = arr.size()-1;
        
        while(right - left + 1 > k){
            int distL = abs(arr[left] - x);
            int distR = abs(arr[right] - x);
            
            if(distL > distR)
                left++;
            else
                right--;
        }
        
        vector<int> indices = {left, right};
        cout << indices[0] << endl;
        cout << indices[1] << endl;
        vector<int> answer;
        while(left <= right){
            answer.push_back(arr[left]);
            left++;
        }
        return answer;
    }
};

// Modified Binary Search
// Time Complexity -> O(log(n-k)) + O(k);
// Space Complexity -> O(k), answer vector of size 'k'
// Problems Faced - No!
// It runs on Leetcode
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int n = arr.size();
        int low = 0;
        int high = n-k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distH = arr[mid+k] - x;
            if(distS > distH)
                low = mid+1;
            else
                high = mid;
        }
        vector<int> answer;
        for(int i = low; i < low + k; i++){
            answer.push_back(arr[i]);
        }
        return answer;
    }
};

// Binary Search to find the closest element and then expanding the window.
// Time Complexity -> O(log(n)) + O(2k);
// Space Complexity -> O(k), answer vector of size 'k'
// Problems Faced - No!
// It runs on Leetcode
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        if(k == arr.size())
            return arr;
        int n = arr.size();
        int low = 0;
        int high = n-1;
        int mid;
        int closest;
        while(low < high){
            mid = low + (high - low)/2;
            if(arr[mid] == x)
                break;
            
            if(x > arr[mid])
                low = mid+1;
            else if(x < arr[mid])
                high = mid;
        }
        int ptr;
        if(low == high){
            closest = arr[low];
            ptr = low;
        }else{
            closest = arr[mid];
            ptr = mid;
        }
            
        //cout << ptr << endl;
        cout << closest;
        int left = ptr; int right = ptr;
        int count = 1;
        vector<int> answer;
        while(left > 0 && right < n-1 && count <= k){
            if((x - arr[left-1]) > (arr[right+1] - x)){
                right++;
                count++;
            }
            else{
                left--;
                count++;
            }
        }
        
        while(count <= k && right == n-1){
            left--;
            count++;
        }
        while(count <= k && left == 0){
            right++;
            count++;
        }    
        
        if(abs(x - arr[left]) <= abs(x - arr[right]))
            right--;
        else
            left++;
        
        for(int i = 0; i < k; i++){
            answer.push_back(arr[left]);
            left++;
        }
        return answer;
    }
};