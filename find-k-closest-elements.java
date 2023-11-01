class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-1;
        while(high - low >=k){
            int highDist = Math.abs(arr[high] -x);
            int lowDist = Math.abs(arr[low] - x);
            if(highDist >= lowDist){
                high--;
            }
            else{
                low++;

            }

        }

        List<Integer> result = new ArrayList<>();
        for(int i= low; i<= high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}


/*


If there are two sets of k closest elements. We need to take the first one.
Brute force : find the difference between x and number, sort the differences.
TC : O(nlogn)
Optimisation is to maintain Max Heap → n logk
We can also do it by 2 pointers  → O(n-k)
Binary Search and window -> log(n) + O(k)





 */