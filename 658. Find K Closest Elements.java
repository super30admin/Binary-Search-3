class Solution {// time of O(lg (n-k))+O(k) and space is O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      ArrayList<Integer>  output = new ArrayList<>();
        int low = 0 ;
        int high = arr.length - k ;
        int mid ;
        while(low<high){
            mid = low + (high - low)/2 ;
            if(x-arr[mid] > arr[mid+ k] - x){
                low = mid + 1 ;
            }else{
                high = mid;
            }
        }
        for(int i = low ; i< low+k ; i++){
            output.add(arr[i]);
        }
        return output;
    } 
}