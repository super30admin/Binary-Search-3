class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;

        while (high- low >=k){
            if (Math.abs (arr[low]-x)<=Math.abs (arr[high]-x)){
                high--;
            } else {
                low ++;
            }

        }
    List<Integer> res = new ArrayList<>();
        for (int i = low;i <= high;i++){
                res.add(arr[i]);
        }
        return res;
    }
}
