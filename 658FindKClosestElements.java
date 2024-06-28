/*
Approach 1: Best approach, finding the starting points of those k elements which we are looking for, as it is sorted array
then apply binary search on those n-k points 
TC: log(n-k)
SC: O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         int low = 0;
        int high = arr.length - k; //it can be the last starting point of those k elements which we are looking for
        while(low<high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            //we move towards the smaller distance
            if( distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low +k ; i++){
            result.add(arr[i]);
        }
        return result;

    }
}
