// Time Complexity: O(n-k) where n are total number of elements in array and k is num of elements required
// Space Complexity: O(1)
// Idea here is to use 2 pointer to make the window of k elements by checking the distance between the target and left and right element.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        while(arr==null || arr.length == 0) return result;
        int l = 0; int h = arr.length-1;
        while(h-l+1>k) {
            int distL = Math.abs(x - arr[l]);
            int distH = Math.abs(x - arr[h]);
            if(distL>distH) l++;
            else h--;
        }
        for(int i=l; i<h+1; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}