
// Time Complexity : O(lonN + K)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left,right;
        if(arr == null || arr.length == 0) return new ArrayList<>();
        if(arr[0] == x){
            left = 0;
            right = k-1;
        }
        else if(arr[arr.length-1] == x){
            left = arr.length-k;
            right = arr.length-1;
        }
        else{
            int index = binarySearch(arr,x);
            System.out.println(index);
            left = index;
            right = index;
        }
        while(right-left+1 < k){
            if(left > 0 && right < arr.length-1){
                if(x - arr[left-1] <= arr[right+1] - x)
                    left--;
                else
                    right++;
            }else{
                if(left > 0 && right < arr.length)    left--;
                if(right < arr.length-1 && right-left+1 < k)    right++;
            }
        }
        
        for(int i = left ; i <= right ; i++) result.add(arr[i]);
        return result;
    }
    private int binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) low = mid+1;
            else high = mid - 1;
        }
        if(low == 0) return low;
        if(low == arr.length) return low-1;
        if(Math.abs(arr[low-1] -x) <= Math.abs(arr[low] - x )) return low-1;
        else return low;
    }
}
