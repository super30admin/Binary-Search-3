// TC : O(log(n-k))
// SC : O(1)
// binary search solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        
        int n = arr.length;
        int low =0;
        int high=n-k;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            int distStart = x-arr[mid];
            int distEnd = arr[mid+k]-x;
            
            if(distStart>distEnd){
                low = mid+1;
            }
            else{
                high=mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}