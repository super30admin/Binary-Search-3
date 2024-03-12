///Accepted on LT
//Time is O(log n)
//idea is to perform binaray search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int h = arr.length - k;
        while(l<h){
            int m = (l+h)/2;
            int ds = x - arr[m];
            int de = arr[m+k]-x;
            if(ds>de){
                l = m+1;
            }
            else{
                h = m;
            }
        }

        List<Integer> li = new ArrayList<>();
        for(int i = l;i<l+k;i++){
            li.add(arr[i]);
        }
        return li;
    }
}