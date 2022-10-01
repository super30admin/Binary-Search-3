// Time Complexity : O(LogN+k)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use binary search to find the starting point of the window
start=0 and end is arraylen-k
Once the start index is found, add k elements from it to result
*/
public class KclosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result= new ArrayList<>();

        int left=0, right=arr.length-k,mid;

        while(left<right){
            mid=left+(right-left)/2;
            int leftDistance=x-arr[mid];
            int rightDistance=arr[mid+k]-x;
            if(leftDistance>rightDistance){
                left=mid+1;
            }else{
                right=mid;
            }
        }

        for(int i=left;i<left+k;i++)
            result.add(arr[i]);

        return result;
    }
}
