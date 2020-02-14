//Time Complexity:O(log N)
//Space Complexity: O(1)
//Accepted on Leetcode: Yes
//Approach Binary Search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        //base case
        if(arr==null || arr.length==0){
            return result;
        }
        if(arr.length==1){
            result.add(arr[0]);
            return result;
        }
        int left = 0;
        int right = arr.length-k;

        while(left<right){
            int mid = left + (right-left)/2;
            int diffL = Math.abs(arr[mid]-x);
            int diffR = Math.abs(arr[mid+k]-x);

            if(diffL > diffR){
                left = mid+1;
            }
            else{
                right = mid;
            }    
        }
        for(int i=left; i<left + k ; i++){
            result.add(arr[i]);
        }

        return result;
    }
}