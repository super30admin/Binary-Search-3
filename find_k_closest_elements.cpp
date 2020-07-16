//4 approaches
//1. Brute force approach find the distance of each and then sort it 
// Time Complexity : O(nlogn) //O(n+nlogn)
// Space Complexity : O(n) // distance array



//2. Heap-sort:find the distance of each and then sort it using Heap
// Time Complexity : O(nlogk) //Heapify technique
// Space Complexity : O(n) // distance array
class comparator{
  public:
    bool operator()(const pair<int,int> &a, const pair<int,int> &b){
        if(a.second == b.second) return b.first > a.first;
        else return b.second > a.second;
    }
};
class comparator2{
  public:
    bool operator()(const int &a, const int &b){
         return a > b;
    }
};
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //edge case
        if(k==arr.size()) return arr;
        //distance array
        vector<pair<int, int>> distance_arr; //number, distance
        for(int i =0; i<arr.size(); i++){
           pair<int,int> temp(arr[i], abs(arr[i]-x));
           distance_arr.push_back(temp);
        }
        //heap sort //custom comparator function written
        priority_queue<pair<int,int>, vector<pair<int,int>>, comparator> pq;
        for(int i =0; i<distance_arr.size(); i++){
            pq.push({distance_arr[i].first, distance_arr[i].second});
            if(pq.size() > k) pq.pop();
        }
        vector<int> result(k,0);
        //min heap comparator used
        priority_queue<int, vector<int>, comparator2> pq2; // or priority_queue<int, vector<int>, greater<int>> pq2;
        for(int i=0; i<k; i++){
            pair<int,int> temp = pq.top();
            pq.pop();
            pq2.push(temp.first);
        }
        for(int i=0; i<k; i++){
            int temp = pq2.top();
            pq2.pop();
            result[i] = temp;
        }
        return result;
    }
};

//3. Two pointer method
// Time Complexity : O(n) //traversal time
// Space Complexity : O(1) //
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //edge case
        if(k==arr.size()) return arr;
        
        unsigned int first_ptr=0; unsigned int second_ptr= arr.size()-1; // referencing via indexes
        int distL,  distR;
        while((second_ptr-first_ptr) >=k){
            distL = abs(arr[first_ptr]-x);
            distR = abs(arr[second_ptr]-x);
            if(distL > distR) first_ptr++;
            else second_ptr--;
        }
        vector<int> result;
        for(int i=0; i<k; i++){
            result.push_back(arr[first_ptr+i]);
        }
        return result;
    }
};

//4. Binary search:
// Time Complexity : O(log n)
// Space Complexity : O(1)

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        //edge case
        if(k==arr.size()) return arr;
        
        unsigned int low =0; unsigned int high= arr.size()-k; // referencing via indexes
        int distL,  distH, mid;
        while(low<high){
            mid = low +(high-low)/2;
            distL = abs(arr[mid]-x);
            distH = abs(arr[mid+k]-x);
            if(arr[mid] == arr[mid + k]){
                if(x > arr[mid])
                    low = mid + 1;
                else
                    high = mid;
            } else {
                if(distL > distH)
                    low = mid + 1;
                else
                    high = mid;
            }
        }
        vector<int> result;
        for(int i=0; i<k; i++){
            result.push_back(arr[low+i]);
        }
        return result;
    }
};
