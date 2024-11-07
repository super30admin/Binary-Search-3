
//brute force- make a differece array from x and given sorted array, get 4 smallest ele from result array and sort them
//tc- nlogn + n +k

//or we can have max heap of size k based on the distance max heap- tc- nlogk; min heap - nlogn-k

// //2pointer. tc-  O(n) + O(n-k) +k
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         int low = 0, high = arr.length - 1;

//         while(high - low + 1 > k){
//             int distL = Math.abs(arr[low] - x);
//             int distH = Math.abs(arr[high] - x);

//             if(distL > distH){
//                 low++;
//             }else{
//                 high--;
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         for(int i = low; i <= high; i++){
//               result.add(arr[i]);
//         } 
//         return result;
//     }
// }


//heap logic
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{//0-dist, 1 - element
//              if(a[0] == b[0]){
//                 return b[1] - a[1];
//              }else{
//                 return b[0] - a[0];
//              }
//         });

//         for(int i = 0; i < arr.length; i++){
//             int dist = Math.abs(x - arr[i]);
//             pq.add(new int[]{dist, arr[i]});

//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         while(!pq.isEmpty()){
//             result.add(pq.poll()[1]);
//         }

//         Collections.sort(result);
//         return result;
 
//     }
// }


//binary search tc- logn-k
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;

        while(low < high){
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k ; i++){
              result.add(arr[i]);
        } 
        return result;
    }
}