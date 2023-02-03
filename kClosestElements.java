// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null || arr.length==0){
            return new ArrayList<>();
        }   
        
        int l=0, r= arr.length-1;
        while(r-l+1>k){
            int left=x-arr[l];
            int right=arr[r]-x;
            
            if(left>right){
                l++;
            }else{
                r--;
            }
        }
        
        List<Integer> list=new ArrayList<>();
        
        for(int i=l;i<=r;i++){
            list.add(arr[i]);
            
        }
        return list;
    }
}