Executed in Leetcode-Yes
Time Complexity- O(n-k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      if(arr==null||arr.length==0) return new ArrayList<Integer>();
        int high=arr.length-1-k, low=0; int mid=0;
        while(high>low){
            mid= low+(high-low)/2;
            int distLeft= Math.abs(arr[mid]-x);
            int distRight= Math.abs(arr[mid+k]-x);
            if(distLeft>distRight){
                low=mid+1;
            }else
                high=mid-1;
        }
        List<Integer> resukt= new ArrayList<Integer>();
        for(int i=mid;i<mid+k;i++){
            resukt.add(arr[i]);
        }
        return resukt;
    }
}
