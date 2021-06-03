// -------------(USING TWO POINTERS APPROACH)-----------------------------------//
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        if(arr == null || arr.length == 0) return li;
        int low = 0;
        int high = arr.length - 1;
        while(high - low + 1 > k){
            int left = Math.abs(arr[low] - x);
            int right = Math.abs(arr[high] - x);
            if(right >= left){
                high--;
            }else{
                low++;
            }
        }
        for(int i = low; i <= high; i++){
            li.add(arr[i]);
        }
        return li;
    }
}


//TIME COMPLEXITY = O(n - k)
//SPACE COMPLEXITY = O(1);  



// -------------(USING BINARY SEARCH APPROACH)-----------------------------------//

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        if(arr == null || arr.length == 0) return li;
        int low = 0;
        int n = arr.length;
        int high = n - k;
        while(low < high){
            int mid = low + (high - low ) / 2;
            int left = x - arr[mid];
            int right = arr[mid + k] - x;
            if(left > right){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        for(int i = low; i < low + k; i++){
            li.add(arr[i]);
        }
        return li;
    }
}

//TIME COMPLEXITY = O(log(n- k)
//SPACE COMPLEXITY = O(1);
