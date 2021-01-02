
// ## Problem2 
// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

//idea- idea is to use 2 pointers low and high and keep moving in accordance to the difference
//TC - O(n)
class Solution {
public:
    vector<int> result;
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        if(arr.size()==0){
            return result;
        }        
        int low= 0;
        int high= arr.size()-1;
        
        while( high-low +1 >k){
            if( abs( x- arr[low]) < abs(arr[high] - x) ){
                high--;
            }
            else if( abs( x- arr[low]) > abs(arr[high] - x) ){
                low++;
            }
            else{
                high--;
            }
        }
        
        for(int i=low ; i<=high; i++){
            result.push_back( arr[i]);
        }
        return result;
    }
};


//idea - binary search 
//TC - O(logn)

class Solution {
public:
    vector<int> result;
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        if(arr.size()==0){
            return result;
        }        
        int low= binary_search( arr,k, x, 0, arr.size()-k);
        
        
        
        for(int i=low ; i< low+k; i++){
            result.push_back( arr[i]);
        }
        return result;
    }
    
    int binary_search( vector<int> arr, int k, int x ,int low ,int high){
        int ans =-1;
        while(low <=high){
            
            int first= low + (high-low)/2;
            int last = first +k-1;
            
            if(first-1 >=0 && (x - arr[first-1]  <= arr[last]-x)){
                high = first - 1;
            }
            else if( last +1 < arr.size() && (x-arr[first] > arr[last+1] -x)){
                low =  first + 1;
            }
            else{
                return first;
            }
        }
      return ans;  
    }
};