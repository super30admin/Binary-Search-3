// for the given array we need to find the kth closet element to the x 
// [1,2,3,4,5]  k = 4 , x = 3
// for the first approach we can get the difference or the mod difference with each int in the array
// two pointer
// we can intialize two pointers start and end 
// and if the diff of left from the x is greater than the difference of right from x
// then left++
// otherwise right--;
//untill we find the range of k
//return array of [stat, end]

//Time complxity in the worst case is O(N)

// other approach would be finding the closest element ot x with binary search and expand the eange with two pointer


class Solution {
public:
    int binarySearch(vector<int> &nums, int target)
    {
        int start = 0;
        int end  = nums.size()-1;
        
        //calculate the mid
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid])
            {
                end = mid-1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return start;
    }
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int index = binarySearch(arr,x);

        //once we have the insertion point
        int left = index-1;
        int right = index;

        while(k>0)
        {
            //edge case
            if(left < 0)
                right++;
            else if(right >= arr.size())
                left--;
            //compare both pointer values
            else if(abs(arr[left]-x) <= abs(arr[right] -x))
                left--;
            else
                right++;
            k--;
        }
        return vector<int>(arr.begin()+left+1,arr.begin() + right);
    }
};
//Time complexity O(log n) for the binary search + O(K) for two pointer
// space complexity O(1)