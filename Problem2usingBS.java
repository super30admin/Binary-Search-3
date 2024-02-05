class Solution {
    //TC: O(log(n-k) + k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //to find x
        int low = 0;
        int high = arr.length -1;
        while(high - low >= k){
                int diffR = Math.abs(arr[high] - x);
                int diffL = Math.abs(arr[low] - x);
                if(diffR < diffL){
                   low++;
                }else high--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = low; i<=high; i++) list.add(arr[i]);
        return list;
    }
}