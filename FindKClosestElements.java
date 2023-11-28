// TC : O(log(n-k)) + O(k)
// SC : O(1)

package S30_Codes.Binary_Search_3;
import java.util.ArrayList;
import java.util.List;

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length-k;

        while(start < end){
            int mid = (end-start)/2 + start;

            if(arr[mid] == arr[mid+k]){
                if(x <= arr[mid])
                    end = mid;
                else
                    start = mid+1;
            }
            else{
                int d1 = Math.abs(x - arr[mid]);
                int d2 = Math.abs(x - arr[mid+k]);

                if(d1 <= d2)
                    end = mid;
                else
                    start = mid+1;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=start; i<start+k; i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}
