//Time Complexity: O(n-k)
//Space Complexity: O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low=0, high = arr.length-1;

        while(high - low +1 > k){

            int distL = Math.abs(x - arr[low]);
            int distH = Math.abs(x - arr[high]);

            if(distL > distH) low++;
            else high--;
        }

        List<Integer> result = new ArrayList<>();
        for( int i=low; i< low+k; i++){
            result.add(arr[i]);
        }

        return result;


    }
}