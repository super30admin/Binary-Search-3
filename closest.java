class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       /* List<Integer>res=new ArrayList<>();
        int l=0,r=arr.length-1;
        while(r-l+1>k){
            int distl=x-arr[l];
            int distr=arr[r]-x;
            if(distl>distr){
                l++;
            }
            else{
                r--;
            }
        }
        for(int i=l;i<=r;i++){
            res.add(arr[i]);
        }
        return res; */
        if(arr==null||arr.length==0)return new ArrayList<>();
        List<Integer>res=new ArrayList<>();
        int l=0,h=arr.length-k;
        while(l<h){
            int m=l+(h-l)/2;
            int diss=x-arr[m];
            int dise=arr[m+k]-x;
            if(diss>dise)l=m+1;
            else h=m;
        }
        for(int i=l;i<l+k;i++){
            res.add(arr[i]);
        }
        return res; 
    }
}