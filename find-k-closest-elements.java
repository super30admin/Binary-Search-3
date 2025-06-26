// //MaxHeap/priority Queue: because there is a 'k' in question. 'Closest' -> MaxHeap
// //TC = O(nlogk)
// //SC = O(n)
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> result = new ArrayList<>();
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
//             int dista = Math.abs(x-a);
//             int distb = Math.abs(b-x);
//             if(dista == distb){
//                 return b-a;
//             }
//             return distb - dista;
//         });
//         for (int i = 0; i < arr.length; i++){
//             pq.add(arr[i]);
//             if(pq.size()>k){
//                 pq.poll();
//             }
//         }
//         while(!pq.isEmpty()){
//             result.add(pq.poll());
//         }
//         Collections.sort(result);
//         return result;
//     }
// }

// //Two Pointers: because it is a sorted array
// //TC = O(n)
// //SC = O(1)
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> result = new ArrayList<>();
//         int high = arr.length-1;
//         int low = 0;
//         while(high-low >=k ){
//             int distl = Math.abs(x - arr[low]);
//             int disth = Math.abs(x - arr[high]);
//             if(distl > disth){
//                 low++;
//             } else {
//                 high --;
//             }
//         }
//         for(int i =low; i<=high; i++){
//             result.add(arr[i]);
//         }
//         return result;
//     }
// }

//Binary Search: on the starting index of a range
//TC = O(logn + k) ,logn for binary search
//SC = O()
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while(low < high){ //finding range = log(n-k)
            int mid = low + (high - low)/2;
            int dists = x - arr[mid];
            int diste = arr[mid+k] - x;
            if(dists > diste){
                low = mid + 1;
            } else if(diste > dists){
                high = mid;
            }
        }
        for(int i=low; i<=high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}