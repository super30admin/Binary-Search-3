class Solution {

    //BinarySearch Approach

    //Time Complexity: O(log(n-k))
    //Space Complexity: O(1)

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int low = 0;                                        //low pointer
        int high = arr.length - k;                          //high pointer

        while(low < high){                                  //iterate till low<high

            int mid = low + (high-low)/2;                   //get the mid element index

            int distanceLow = x - arr[mid];                 //get the distance from low
            int distanceHigh = arr[mid+k] - x;              //get the distance from high

            if(distanceLow > distanceHigh){                 //if distanceLow >distanceHigh
                low = mid+1;                                //update low pointer to mid+1
            }
            else{
                high = mid;                                 //update high pointer
            }
        }

        List<Integer> result = new ArrayList<>();           //to store the result

        for(int i=low; i<low+k; i++){                       //iterate from low to low+k element,
            result.add(arr[i]);                         //add into result
        }
        return result;                                      //return result
    }




    //Two Pointer Approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)

//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         int pointer1 = 0;
//         int pointer2 = arr.length-1;

//         while(pointer2 - pointer1 + 1 > k ){

//             int distance1 = Math.abs(arr[pointer1] - x);
//             int distance2 = Math.abs(arr[pointer2] - x);

//             if(distance1> distance2){
//                 pointer1++;
//             }
//             else{
//                 pointer2--;
//             }
//         }

//         List<Integer> result = new ArrayList<>();

//         for(int i=pointer1 ; i<= pointer2; i++){
//             result.add(arr[i]);
//         }
//         return result;
//     }



    //Heap Approach
    //Time Complexity: O(n*log(k) + k*log(k))
    //Space Complexity: O(k)

//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         Queue<int[]> pq = new PriorityQueue<>( (a, b) -> {

//             if(a[1] == b[1]){
//                 return b[0] - a[0];
//             }
//             return b[1] - a[1];

//         });

//         for(int i=0; i<arr.length; i++){

//             pq.add(new int[]{ arr[i], Math.abs(arr[i] - x) });

//             if(pq.size() >k){
//                 pq.poll();
//             }
//         }

//         List<Integer> result = new ArrayList<>();
//         while(!pq.isEmpty()){

//             int[] curr = pq.poll();
//             result.add(curr[0]);
//         }
//         Collections.sort(result);
//         return result;
//     }
}


public class FindKClosestElementLC658 {
}
