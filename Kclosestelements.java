// Time complexity - O(n-k)
// Space complexity - O(1)
// solved on leetcode - yes
//Faced any issues - no
// Solving using 2 pointer solution, until we reach middle k elements. then we are adding to the list

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=0,j = arr.length-1;
        List<Integer> result = new ArrayList<>();

        while(true) {
            if(j-i+1 == k) break;
            if(Math.abs(arr[i]-x) <= Math.abs(arr[j]-x)) {
                j--;
            } else {
                i++;
            }
        }

        for(int p = i;p<=j;p++) 
        result.add(arr[p]);
        return result;
    }
}
