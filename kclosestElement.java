//TC : O(log(n-k))
//SC : O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0,high=arr.length-k;
    
        while(low<high){
            int mid = low + (high-low)/2;
            int difL = x-arr[mid];
            int difR = arr[mid+k]-x;
            // if we need to include higher element when distance is same then difR = arr[mid+k]-x
            if(difL > difR)
                low = mid +1;
            else
                high = mid;
        }
        List<Integer> result = new ArrayList<>(); 
        for(int i = low;i<low+k;i++){
            result.add(arr[i]);
        }
        // if we need range --> low to low + k
        
        return result;
    }
}
