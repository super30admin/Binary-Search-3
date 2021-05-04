
//Approach - Binary search will be used to find the index of the exact target x or the index closest to x
// then the remaining (k-1) elements are decided and put into the result list
//Time Complexity - O(log N + k) - N is length of arr
//Space Complexity - O(1) - excluding the result list

class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int closest = binarySearch(arr, x);
    int left = closest-1;
    int right = closest+1;

    LinkedList<Integer> result = new LinkedList<>();
    result.addFirst(arr[closest]);

    while(k > 1){
      if(left < 0){
        result.addLast(arr[right++]);
      }
      else if(right == arr.length){
        result.addFirst(arr[left--]);
      }
      else{
        if(x-arr[left] <= arr[right]-x){
          result.addFirst(arr[left--]);
        }
        else{
          result.addLast(arr[right++]);
        }
      }
      k--;
    }
    return result;
  }

  public int binarySearch(int[] arr, int x){

    int low =0, high = arr.length-1;

    while(low < high){
      int mid = low+(high-low)/2;

      if(arr[mid] == x){
        return mid;
      }
      if(arr[mid] < x){
        low = mid+1;
      }
      else{
        high = mid;
      }
    }

    if(low == 0){
      return low;
    }
    else if(Math.abs(arr[low] - x) < Math.abs(arr[low-1] - x)){
      return low;
    }
    else{
      return low-1;
    }
  }
}



//Approach - a sliding window of size k will be shifted through the array until it is placed around the numbers <= x
//Time Complexity - O(N-k) - where N is length of arr
//Space Complexity - O(1) - excluding the result list
class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int left=0, right=arr.length-1;

    while(right-left+1 > k){
      if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
        right--;
      }
      else{
        left++;
      }
    }

    List<Integer> result = new ArrayList<>();
    for(int i=left; i<=right; i++){
      result.add(arr[i]);
    }
    return result;
  }

}



// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         List<Integer> result = new ArrayList<>();
//         PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1]-b[1]);
//         for(int i=0; i<arr.length; i++){
//             heap.add(new int[]{ arr[i], Math.abs(x-arr[i]) });
//         }

//         int index = 0;
//         while(index < k){
//             int[] item = heap.poll();
//             result.add(item[0]);
//             index++;
//         }

//         Collections.sort(result);
//         return result;
//     }
// }
