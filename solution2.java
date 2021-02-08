//Space Complexity:O(1)
//Time Complexity: O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       List<Integer> result = new ArrayList<>();
        if(arr.length == 0 || arr == null)return result;
        int low = 0;
        int high = arr.length-1;
        while(high-low>=k){
            int distL = Math.abs(arr[low]-x);
            int distR = Math.abs(arr[high]-x);
            if(distL>distR){
                low++;
            }else{
                high--;
            }
           }
         for(int i = low;i<=high;i++){
                result.add(arr[i]);
        }
     return result;   
    }
}