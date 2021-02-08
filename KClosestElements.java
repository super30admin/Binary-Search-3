// Time Complexity : O(log(n))+k
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();

        //edge
        if(arr == null || arr.length == 0){
            return result;
        }

        //binary search to find closest element to our target
        int bs = binarySearch(arr, x);
        result.addFirst(arr[bs]);


        //closest elements could be on right/left of it
        int right = bs + 1;
        int left = bs - 1;

        //while we still have k numbers left
        while(k > 1){
            //if left/right is at array boundary, add the opposite one
            if(left < 0){
                result.addLast(arr[right]);
                right++;
            }
            else if(right == arr.length){
                result.addFirst(arr[left]);
                left--;
            }
            //if there is a tie, add the left one, unless right is smaller
            else{
                if(x - arr[left] > arr[right] - x){
                    result.addLast(arr[right]);
                    right++;
                }
                else{
                    result.addFirst(arr[left]);
                    left--;
                }
            }

            k--;
        }
        return result;
    }


    private int binarySearch(int arr[], int x){
        int low = 0;
        int high = arr.length - 1;
        //binary search to get to closest element to x or at x
        while(low < high){
            int mid = low + (high - low)/2;

            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] > x){
                high = mid;
            }
            else{
                low = mid + 1;
            }

        }
        //if end up at beginning
        if(low == 0) return low;
        //if curr element is closer to x than one below
        if(Math.abs(arr[low] - x) < Math.abs(arr[low - 1] - x)) return low;

        return low - 1;
    }
}