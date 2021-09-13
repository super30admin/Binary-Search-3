class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr==null || arr.length == 0){
            return result;
        }
        int left = 0, right = arr.length - 1;
        while(right - left + 1 > k){
            //Shrink the array
            int distLeft = x - arr[left];
            int distRight = arr[right] -x;
            if(distLeft>distRight){
                left++;
            }else{
                right--;    
            }
        }
           
            for(int i=left; i<= right ; i++){
                result.add(arr[i]);
            }
        
        return result;
    }
}
