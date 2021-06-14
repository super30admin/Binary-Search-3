//Time Complexity: O(logn + k)
//Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        int pos = binarySearch(arr, x);
        res.add(arr[pos]);
        int l = pos - 1;
        int r = pos + 1;
        while(k > 1){
            //closest element lies on the first
            if(l < 0){
                res.addLast(arr[r++]);
            }
            else if(r >= arr.length){
                res.addFirst(arr[l--]);
            }
            else{
                if(x - arr[l] <= arr[r] - x){
                    res.addFirst(arr[l--]);
                }
                else{
                    res.addLast(arr[r++]);
                }
            }
            k--;
        }

        return res;
    }

    private int binarySearch(int[] arr, int x){
        int low  = 0;
        int high = arr.length-1;

        while(low<high){
            int mid  = low + (high - low)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                low = mid + 1;
            else
                high = mid;
        }
        if(low == 0)
            return low;
        //closest on the lower side
        if(Math.abs(arr[low] - x) < Math.abs(arr[low - 1] - x))
            return low;
        return low - 1;
    }
} 

