//TC: O(n-k)
//SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; int high = arr.length - 1;
        List<Integer> res = null;
        if(arr == null || arr.length == 0) return res;
        while(high-low+1>k){
            if(Math.abs(arr[low]-x) > Math.abs(arr[high]-x)){
                low++;
            }
            else {
                high--;
            }
        }
        res = new ArrayList();
        for(int i = low; i < low+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}

//TC: O(log(n-k))
//SC: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; int high = arr.length - k;
        List<Integer> res = new ArrayList();
        if(arr == null || arr.length == 0) return res;
        while(low < high){
            int mid = low + (high-low)/2;
            int distL = Math.abs(x - arr[mid]);
            int distR = Math.abs(x - arr[mid+k]);
            if(distL>distR){
                low = mid+1;
            }
            else{
                if(arr[mid] == arr[mid + k]){
                    low = mid+1;
                }
                else{
                    high = mid;
                }
            }
        }
        for(int i = low; i < low+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
