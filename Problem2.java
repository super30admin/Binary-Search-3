class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       if(arr == null || arr.length==0){
            return new ArrayList<>();
       }

       int low = 0;
       int high = arr.length - k;
       while(low < high){
       int mid = low + (high-low)/2;
        int disleft = x - arr[mid];
        int disright = arr[mid+k] - x;
        if(disleft>disright){
            low = mid+1;
        }
        else{
            high = mid;
        }
       }
    
        List<Integer>result = new ArrayList<>();
       for(int i = low ; i< low+k;i++){
            result.add(arr[i]);
       }

       return result;
    }
}
