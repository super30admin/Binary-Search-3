class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // using binary search
        int low = 0;
        int high = arr.length - k;

        while(low<high){

            int mid = low + (high - low )/2;
            int disStart = (x - arr[mid]);
            int disEnd = (arr[mid+k] - x); 
            // int disStart = Math.abs(x- arr[mid]);
            // int disEnd = Math.abs(arr[mid+k] - x);
            if(disStart > disEnd ){
                low = mid+1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }

        return result;
    }
}