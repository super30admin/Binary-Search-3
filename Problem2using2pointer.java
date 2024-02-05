class Solution {
    //Tc : O(n-k)
    //Two POinter 
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0; int right = arr.length - 1;
        int n = arr.length;

        while(right - left >= k){
            int distR = Math.abs(arr[right] - x);
            int distL = Math.abs(arr[left] - x);
            if(distR < distL) left++;
            else right--;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}