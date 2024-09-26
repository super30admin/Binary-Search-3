// Time Complexity - O(n-k)
// Space Complexity - O(1)

// Two pointer solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int low = 0, high = arr.length-1;
        while(high-low+1 > k) {
            int distL = Math.abs(x-arr[low]);
            int distR = Math.abs(x-arr[high]);
            if(distL > distR) low++;
            else high--;
        }
        for(int i=low; i<low+k;i++) {
            res.add(arr[i]);
        }
        return res;
    }
}