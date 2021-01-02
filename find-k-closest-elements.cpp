//Time - O(logn)
//Space - O(1)
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int idx = findIdx(arr,x);
        int l = idx,r = idx+1;
        int left,right;
        
        vector<int> ret;
        while(ret.size()<k){
            if(l>=0 && r<arr.size()){
                left = arr[l]; 
                right = arr[r];
                if(abs(left-x)<abs(right-x)){
                    ret.push_back(left);
                    l--;
                }else if(abs(left-x) == abs(right-x) && left<=right){
                    ret.push_back(left);
                    l--;
                }else if(abs(left-x)>abs(right-x)){
                    ret.push_back(right);
                    r++;
                }
            }else if(l<0){
                ret.push_back(arr[r++]);
            }else if(r>=arr.size()){
                ret.push_back(arr[l--]);
                
            }
        }
        
        sort(ret.begin(),ret.end());
        return ret;

    }
    
    int findIdx(vector<int> arr, int x){
        
        int l = 0, r = arr.size()-1;
        int m;
        
        while(l+1<r){
            
            m = l + (r-l)/2;
            
            if(arr[m] == x){
                return m;
            }else if(arr[m]<x){
                l = m;
            } else if(arr[m]>x){
                r = m;
            }
        }
        
        return abs(arr[l]-x)<=abs(arr[r]-x) ? l:r;
    }
};