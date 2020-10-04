// Time Complexity : O(log n-k) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//to find an element in sorted list, we go for binary search
//to find k closest, our approach would be similar
//taking a window initially with l=0, h=len-k
//at each point we shall try to check if we wnat to move left of mid or right of mid
//by checking the absolute diff b/w x and arr[mid] , x and arr[mid+k]
//when we know the starting point, just loop to create a list with size k.


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int h=arr.length-k;
        
        while(l<h){
            int mid=l+(h-l)/2;
            if(Math.abs(x-arr[mid+k]) < Math.abs(x-arr[mid])){
                l=mid+1;
            }
            else{
                if(arr[mid]==arr[mid+k]){
                    l=mid+1;
                }
                else{
                h=mid;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=l;i<l+k;i++){
           res.add(arr[i]); 
        }
        return res;
    }
}