//Two pointer approach
class Solution {

    //Time Complexity : 0(log n ) + 0(k); where n is the no of lements in the array and k is the range to be returned
    //Space Complexity: 0(1)
    //Did it successfully run on leetcode: Yes
    //DId you face ny problem while running the code: No

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();   //declaring the result list to return the result
        int low = 0;    //placing my low pointer at the beginning to capture the 1st index to be returned
        int high = arr.length - 1;  //high at the end to capture the end position of the list
        while(high - low + 1 > k){  //keeping the range to k as we have to return k elements
            int start = x - arr[low];   //taking the absolute difference and checking if left pointer needs to be moved or right
            int end = arr[high] - x;//taking absolute difference of right most element
            if(start > end){
                low ++;
            }
            else{
                high -- ;
            }
        }
        for(int i = low; i < low + k; i++){ //running loop form starting point to k and adding them to result
            result.add(arr[i]);
        }
        return result;

    }
}

//Binary Search with interval approach

//Time Complexity : 0(log n-k ) + 0(k); where n is the no of lements in the array and k is the range to be returned
//Space Complexity: 0(1)
//Did it successfully run on leetcode: Yes
//DId you face ny problem while running the code: No


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            int mid = low + (high - low) / 2;
            int left = x - arr[mid];
            int right = arr[mid + k] - x;
            if(left > right){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}