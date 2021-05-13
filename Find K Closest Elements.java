// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    if (arr == null || arr.length == 0)
      return result;

    int low = binary(arr, 0, arr.length - k, k, x);
    int n = low + k;

    while (low < n) {
      result.add(arr[low]);
      low++;
    }
    return result;
  }

  public int binary(int[] arr, int low, int high, int k, int x){
      while (low <= high){
          int first = low + (high-low) / 2;
          int last = first + k - 1;
          
          if (first - 1 >= 0 && (x - arr[first-1] <= arr[last] - x))
              high = first - 1;
          else if (last + 1 < arr.length && (x - arr[first] > arr[last+1] - x))
              low = first + 1;
          else
              return first;
      }
      return low;                                
  }
