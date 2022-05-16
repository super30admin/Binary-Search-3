//time - O(n)
//space - O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr==null || arr.length==0) return result;
        int left = 0, right = arr.length-1;

        while(right-left+1 > k){
            int leftDiff = Math.abs(x - arr[left]);
            int rightDiff = Math.abs(arr[right] - x);
            if(leftDiff > rightDiff)
                left++;
            else
                right--;
        }

        while(left <= right){
            result.add(arr[left]);
            left++;
        }

        return result;
    }
}
