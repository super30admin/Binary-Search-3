/*
Time: O(n) + o(klogk)
Space: O(1) (not considering return array)

Maintain 2 pointers, starting from the immidiate bigger element than x and its previous
Whichever yields smaller difference with x, proceed that way
*/

class Solution {
public:
    vector<int> findClosestElements(vector<int>& v, int k, int x) {
        int n = v.size();
        int right = upper_bound(v.begin(), v.end(), x) - v.begin();
        int left = right-1;

        vector<int> ret;
        while(ret.size()<k){
            int pick;

            //boundary cases
            if(left<0) pick = right;
            else if(right>=n) pick = left;
            else{ //compare the absolute diff
                if( abs(v[left]-x) <= abs(v[right]-x) ){
                    pick = left;
                }
                else{
                    pick = right;
                }
            }

            ret.push_back(v[pick]);
            if(pick==left)  left--;
            else  right++;
        }

        sort(ret.begin(), ret.end());
        return ret;
    }
};
