//Binary Search
//TC : O(log(n-k))
//SC : O(1) 
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length -k;
        while(low < high){
           int  mid = low + (high-low)/2;
           int distS =x-arr[mid];
           int distE = arr[mid+k]-x;
        if(distS > distE){
            low = mid + 1;
        }else {
            high = mid;
        }
        }

        for(int i = low; i<low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
