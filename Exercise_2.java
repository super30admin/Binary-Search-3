class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int s =0, e= arr.length-1;

        while(s<=e){
            int m = s + (e-s)/2;

            if(arr[m] == x){
                e =m;
                break;
            }else if (x < arr[m]) {
                    e =m-1;
            }else{
                s = m+1;
            }
        }
        int l =e;
        int r = e+1;
         int el = 0;

         while(el<k){
             int ld = l ==-1 ? Integer.MAX_VALUE : Math.abs(x-arr[l]);
             int lr = r == arr.length ? Integer.MAX_VALUE : Math.abs(x-arr[r]);

             if(ld <= lr){
                 --l;
             } else {
                 ++r;
             }
             ++el;
         }
         List<Integer> res = new ArrayList<>();
         for(int i = l+1; i<r; ++i) {
             res.add(arr[i]);
         }
         return res;
    }
}
