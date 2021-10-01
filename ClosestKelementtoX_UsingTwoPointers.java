// Time Complexity :O(n-k) if k is very less then it can be O(n) too
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

//two pointer approach, take low and high pointer. run a while loop till l<=h
// calculate element's distance from the x, which ever sides distance is more move that side of pointer by 1. Note : before moving element check no of element between two points is more than k or not ( move only if no of elements between two pointers is more than k)
// finally my result is between pointer 1 to 2 return it


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int l = 0; // pointer 1
        int h = arr.length -1; // pointer 2
        
        while(l<=h)
        {
            int dp1= Math.abs(x-arr[l]); // distance of element at pointer1 from x
            int dp2= Math.abs(x-arr[h]);// distance of element at pointer2 from x
            if(dp1<=dp2) // whichever sides's distance is greater we will move that
            {
                if(h-l+1>k) //  move pointers only, if elements between pointer 1 and 2 is greater than k 
                {
                    h--;
                }
                else
                    break;
            }
            else { 
                if(h-l+1>k)
                {
                    l++;
                }
                else
                    break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = l ; i <= h;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
    }
}