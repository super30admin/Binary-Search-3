//TC: O(log(N-K)
//SC: O(1)  

public class k_closest {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int low = 0,high = arr.length - 1;
            while(high - low >= k){
                if(Math.abs(arr[low]-x) > Math.abs(arr[high]-x))
                    low++;
                else 
                    high--;
            }
            List<Integer> list = new ArrayList<>(); //O(K) not counted as it is output
            for(int i =low ; i <= high ; i++){
                list.add(arr[i]);
            }
            return list;
        }
    }
}
