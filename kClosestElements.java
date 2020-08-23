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
