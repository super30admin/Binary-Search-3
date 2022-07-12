public class KClosestElement {
    // TC is O(log(n-k))
    // SC constant
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;
        while(high-low+1 > k){
            int diff1 = Math.abs(x-arr[low]);
            int diff2 = Math.abs(x-arr[high]);
            if(diff1>diff2){
                low++;
            }else high--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low; i<=high;i++){
            result.add(arr[i]);
        }
        Collections.sort(result);
        return result;
    }
}
