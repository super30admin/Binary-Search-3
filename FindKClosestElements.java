//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int left = 0; int right = arr.length - 1;

        //iterate until the we have a K elements gap and move the left and right pointers
        //based on the distance at Left pointer and Right pointer.
        while(right - left >= k){

            int distL = Math.abs(x - arr[left]);
            int distR= Math.abs(x - arr[right]);

            if(distL > distR){
                left++;
            }
            else{
                right--;
            }
        }

        //Now that left and right are at the right place, extract the elements between these pointers
        //and add to result list.
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }

        return result;
    }
}