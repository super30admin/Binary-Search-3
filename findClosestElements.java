class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r = arr.length-1;
        
        while(k< r-l+1){
            int left = x-arr[l];
            int right = arr[r]-x;
            if(left>right){
                l++;
            }
            else r--;
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=l;i<=r;i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}