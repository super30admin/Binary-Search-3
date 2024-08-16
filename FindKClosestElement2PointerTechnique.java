// Time Complexity : O(n) where n is the number of elements in an array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. In the base condition while checking n ==0 returned 0.0 instead of 1.0 In the comdition endDist >= startDist forgot to add = condition

/*
Approach: Using 2 pointer technique. Start with 2 pointers start positioned at 1st element and end positioned at last element. Then calculate the start distance by x - arr[start] and end distance by arr[end] - x. Move the pointer which is far from x. Then finally add the elements from start to end.
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int start = 0;
        int end = arr.length - 1;
        List<Integer> result = new ArrayList<>();

        while(end - start + 1 > k){

            int startDist = x - arr[start];
            int endDist = arr[end] - x;

            if(endDist >= startDist){
                end--;
            }
            else{
                start++;
            }
        }

        for(int i = start; i <= end; i++){
            result.add(arr[i]);
        }

        return result;
    }
}