// This solution uses binary search to get the start index for the range we need. Every iteration we compare the mid element with mid+k element and either ignore mid or mid+k element based on distance from x. At end we arrive at start and get the range
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=0, j = arr.length-k;
        while(i<j) {
            int mid = i+(j-i)/2;
            int left = x-arr[mid];
            int right = arr[mid+k]-x;
            if(left<=right) {
                j=mid;
            } else {
                i=mid+1;
            }
        }
        List<Integer> response = new ArrayList();
        for(int l=i;l<i+k;l++) {
            response.add(arr[l]);
        }
        return response;
    }
}
