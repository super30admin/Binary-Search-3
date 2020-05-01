//TC:O(LOG(N-K))+O(K)
//SC:O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
       int low = 0;
       int high = arr.length-k;
       while(low<high){
          int mid = low+(high-low)/2;
          int lb = Math.abs(x-arr[mid]);
          int hb = Math.abs(arr[mid+k]-x);
          if(lb <= hb)
             high=mid;
          else
             low=mid+1;
       }
        
       
        List<Integer> l = new ArrayList<>();
       for(int i=low;i<low+k;i++)
           l.add(arr[i]);
        
        
       return l; 
    }
}