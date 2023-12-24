// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class K_Closest_2pointer {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int l=0;
      int h= arr.length-1;

      while(h-l >= k){
        // low is distant apart
        if( x-arr[l] > arr[h] -x) {
          l++;
        }
        // high is distant apart
        else if( x-arr[l] <= arr[h] -x) {
          h--;
        }
      }

      List<Integer> result = new ArrayList<Integer>();
      for( int i=l; i <=h; i++){
        result.add(arr[i]);
      }
      return result;
    }
  }
