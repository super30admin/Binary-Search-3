class Solution {
    //Time complexity: O(n-k)
    //Space complexity: O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        int l=0,h=n-k;
        while(l<h){
            int m=l+(h-l)/2;
            int d=x-arr[m];
            int d1=arr[m+k]-x;
            if(d>d1){
                l=m+1;
            }
            else{
                h=m;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=l;i<l+k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}