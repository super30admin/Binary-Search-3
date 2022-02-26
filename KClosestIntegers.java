/*
time complexity : normal binary search ; O(log(n) + K)
                    range binary search : O(log(n-k) + k)
space complexity : O(1)
*/

class Solution {
  //binary search approach of finding the target first and then the range
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        int low = 0;
        int high = arr.length;
        int mid = 0;

        while(low < high){

            mid = low + (high - low )/2;
            if(arr[mid] == x){
                break;
            }
            else if(arr[mid] > x){
                high = mid;
            }
            else{
                low = mid + 1;
            }

        }

        low = mid;
        high = mid+1;

        List<Integer> list = new LinkedList<>();
        while( high - low  -1 < k){
            if(low < 0 ){
                high++;
            }
            else if(high >= arr.length ||
                    (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x))){
                      low--;
            }
            else{
                    high++;
            }
        }


        for(int i = low+1; i< high; i++){
            list.add(arr[i]);
        }

        return list;


    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
// using binary search to find the range of the closest elements
        int low = 0;
        int high = arr.length - k;//high indicates the max index that the range
                                  // can start from
        List<Integer> list = new LinkedList<>();
        while(low < high){
            int mid = low + (high - low)/2;
            distl = x - arr[mid];
            disth = arr[mid+k] - x;

            if(distl > disth)//this means that on the right side the elements are
                            //closer
            {
              low = mid+1;
            }
            else{
              high = mid;
            }
        }

        for(int i = low+1; i< high; i++){
            list.add(arr[i]);
        }

        return list;


    }
}
