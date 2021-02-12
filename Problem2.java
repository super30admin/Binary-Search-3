// Time Complexity : O(log(n)) + k  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //create a linked list to be able to return the list of elements closest to k whihc can give us flexibilty to add to the fron tnad end
        LinkedList<Integer> res = new LinkedList<>();
        //edge
        if(arr == null || arr.length == 0) return res;
        //call binary search to find the closest element to the x
        int close = binarySearch(arr,x);
        //add the first closest element to the result
        res.addFirst(arr[close]);
        //now add a right and left pointer
        int r = close + 1; 
        int l = close - 1;
        //start a while loop to find the other k closest element the bounds will be while k is greater than 1 since we are finding the elements
        while(k > 1){
            //if the left is going out of bounds
            if(l < 0){
                //add the right to the result because that will be closer
                res.addLast(arr[r]);
                //increment right pointer
                r++;
            }
            //if right goes out of bounds 
            else if(r == arr.length){
                //put left into res at first
                res.addFirst(arr[l]);
                //decrease the left pointer
                l--;
            }
            //now check if you should add the left or right when you are in the middle of the array
            else{
                //if the difference between the left - x compared to right - x is greater 
                if(x - arr[l] > arr[r] - x){
                    //add to the last of res the right
                    res.addLast(arr[r]);
                    //increment r
                    r++;
                }
                //else the difference between the right - x compared to left - x is greater
                else{
                    //add to the front of res the left
                    res.addFirst(arr[l]);
                    //decrease l
                    l--;
                }
            }
            //decrease k to get closer elements
            k--;
        }
        return res;
    }

    private int binarySearch(int arr[], int x){
        //set low and high pointers 
        int l = 0;
        int h = arr.length - 1;
        //start a while loop
        while(l < h){
            //get the mid
            int mid = l + (h-l)/2;
            //check if the mid is the target
            if(arr[mid] == x) return mid;
            //if mid is greater than target then move mid to high
            else if(arr[mid] > x) h = mid;
            //move low to mid = 1
            else l = mid + 1;
        }
        //now check if low ends up being at the first index
        if(l == 0) return l;
        //if the dif between low and low - 1 when subtracted from targe is less then return low;
        if(Math.abs(arr[l] - x) < Math.abs(arr[l-1] - x)) return l;
        //else just return low-1;
        return l - 1;
    }
} 