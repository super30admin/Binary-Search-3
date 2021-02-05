// Time Complexity : The time complexity is O(logn+k) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> output = new LinkedList<Integer>();
        int len = arr.length;

        int start = 0;
        int end = len-1;

        int mid;

        // Binary search to find the closest number to target
        while(start <= end){

            mid = (end-start)/2 + start;

            if(arr[mid] == x){
                break;
            }
            else if(arr[mid] < x){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        if(start > end){
            if(end < 0){
                mid = start;
            }
            else if(start == len){
                mid = end;
            }
            else{
                mid = Math.abs(x-arr[start]) < Math.abs(x-arr[end]) ? start : end;
            }
        }

        int leftMost = mid-1;
        int rightMost = mid+1;

        output.add(arr[mid]);

        // Add k closest elements to the list
        while(output.size() < k){

            if(leftMost < 0){
                output.addLast(arr[rightMost]);
                rightMost++;
            }
            else if(rightMost == arr.length){
                output.addFirst(arr[leftMost]);
                leftMost--;
            }
            else{
                if(Math.abs(x-arr[leftMost]) > Math.abs(x-arr[rightMost])){
                    output.addLast(arr[rightMost]);
                    rightMost++;
                }
                else{
                    output.addFirst(arr[leftMost]);
                    leftMost--;
                }
            }

        }

        return output;

    }
}