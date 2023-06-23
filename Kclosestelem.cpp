// TC:O(logN)
// SC:O(1)

//Approach:
// Is to find the leftmost index of the closest elements window using Binary search


class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) 
    {
        int left=0;
        int right=arr.size()-k;

        while(left<right)
        {
           int mid = (left+right)/2;
        // checking whether the element just out of the selction is valid to be in the closest elements or not
           if(x-arr[mid]>arr[mid+k]-x)
           {
               left=mid+1;
           }
           else
           {
            /*Case 2: x - arr[mid] <= arr[mid + k] - x

              This means that the element at arr[mid] is either closer to x or equally close compared to the element at arr[mid + k].
              In this case, moving the subarray window to the right wouldn't be beneficial, as it would include elements that are farther away from x.
              Therefore, we update right to mid to maintain the possibility of mid being the leftmost index of the subarray containing the closest elements.*/
               right=mid;
           }
        }

        return vector<int>(arr.begin()+left,arr.begin()+left+k);
    }
};