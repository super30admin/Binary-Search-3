/**
 *Time - O(n-k) n-length of the array
 * Space - O(1)
 */
//2 ptr approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> lst = new ArrayList<>();
        int low = 0, high = arr.length-1;
        while(high-low > k-1){
            if(Math.abs(x-arr[low]) > Math.abs(x-arr[high]))
                low++;
            else
                high--;
        }
        while(low<=high){
            lst.add(arr[low++]);
        }
        return lst;
    }
}
// If the given pblm had no duplicates --binary search approach

//class Solution {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> lst = new ArrayList<>();
//        int low = 0, high = arr.length-k,mid = 0;
//        while(low<high){
//            mid = low+(high-low)/2;
//            System.out.println(low+" "+high);
//            int distL = Math.abs(x - arr[mid]);
//            int distR = Math.abs(x - arr[mid+k]);
//            if(distL > distR) low = mid+1;
//            else high = mid;
//        }
//        int l = 0;
//        while(l<k){
//            lst.add(arr[mid++]);
//            l++;
//        }
//        return lst;
//    }
//}