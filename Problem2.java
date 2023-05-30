// Time: O(logN + k)
// Space: O(1)

class Solution {
    List<Integer> res;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        res = new ArrayList<>();
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
            
            return res;
        }
        int xPos = bs(arr,x);
        findClosest(arr,xPos, k,x);
        System.out.println(xPos);
        return res;
    }
    public void findClosest(int[] arr, int idx, int k, int x){
        if(idx<0){
            int i = 0 ;
            while(k>0){
                res.add(arr[i]);
                i++;
                k--;
            }
            return;

        }
        
        int l = idx-1;
        int r = l+1;
        while( r-l -1 <k){
            if(l<0){
                r++;
                continue;
            }
            if(r==arr.length || Math.abs(arr[l]- x) <= Math.abs(arr[r]- x)){
                l--;
            }else {
                r++;
            }
        }
        for(int i = l+1 ; i < r; i++){
            res.add(arr[i]);
        }
        return;
        

    }
    

    public int bs(int[] arr, int x){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid]<x){
                l = mid+1;
            }
            if(arr[mid] == x){
                return mid;
            }
            if(arr[mid]>x){
                r = mid-1;
            }
        }
        return l;
    }
}