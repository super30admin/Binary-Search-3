
/*
 * Time complex - O(n) - n is the length of the citations array
 * Space Complex - constant 
 */

 class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = n -1;
        while( low <= high ){
            int mid = low + (high - low)/2; // avoding integer overflow
            if(citations[mid] >= n - mid){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return n - low;
    }
}