//Binary Search Solution

//O(log(n-k)) + O(k)

// Two Pointer -> O(n)

class Solution {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();

    int low = 0;
    int high = arr.length - 1;

    while (high - low + 1 > k) {
      int distL = Math.abs(x - arr[low]);

      int distR = Math.abs(x - arr[high]);

      if (distL > distR) low++; else high--;
    }

    for (int i = low; i < low + k; i++) {
      result.add(arr[i]);
    }

    return result;
  }
}
