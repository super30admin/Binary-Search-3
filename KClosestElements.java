import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(logn)
// Space Complexity: O(1)

public class KClosestElements {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int n = arr.length;

            int left = 0; int right = n -1;

            while(right - left >= k){

                int distL = Math.abs(arr[left] - x);

                int distR = Math.abs(arr[right] - x);

                if(distL > distR){

                    left++;

                } else{

                    right--;

                }

            }

            List<Integer> result = new ArrayList<>();

            for(int i = left; i <= right; i++){

                result.add(arr[i]);

            }

            return result;

        }

}
