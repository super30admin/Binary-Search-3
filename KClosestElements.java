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


//Two pointer Approach
//Time Complexity: O(N)
class Solution {
    List<Integer> results = new ArrayList<>();
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length < 1)
            return results;

        int low  = 0;
        int high = arr.length - 1;

        while(high - low > k - 1){
            int diffLow  = Math.abs(arr[low]  - x);
            int diffHigh = Math.abs(arr[high] - x);

            if(diffLow > diffHigh)
                low++;
            else
                high--;
        }

        for(int i = low; i<= high; i++)
            results.add(arr[i]);

        return results;
    }
}