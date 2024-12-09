// Approach : Using Binary Search we try to identify the starting range
// Time : log(n-k) + O(k)
// Space : O()
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low =0;
        int high = n-k;

        while(low<high){
            int mid = low + (high-low)/2; // this will be used to find the correct starting range

            // initially consider this mid as correct starting range and calcualate distance
            int distS = x-arr[mid];
            int distE = arr[mid+k] -x;

            if(distS > distE){
                low = mid+1;
            } else{
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =low; i<low+k;i++){
            result.add(arr[i]);
        }  

        return result;      
    }
}

// Approach : Using Max Heap 
// Time : O(nlogk) + O(klogk) pop elements from heap + O(klogk) sort
// Space : O (logk)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
            int distL = Math.abs(x-a);
            int distR = Math.abs(x-b);
            if(distL == distR){
                return b-a;
            }
            return distR - distL; // Descending order
        });

        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}

// Approach : Very Brute Force - while calculating the abs distance sort them according to the distance and then iterate through fist k elements and add it to result and then sort again. 
// Time : O(nlogn) + O(klogk)
// Space : O(1) + O(Auxialry space - converting Array ti Array List)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Convert array to list for sorting
        List<Integer> arrList = new ArrayList<>();
        for (int num : arr) {
            arrList.add(num);
        }
        // [1,2,3,4,8,9,14,16,18,19] x= 13 and k = 4
        Collections.sort(arrList, (a,b) -> {
            int distA = Math.abs(x - a); // 12 10 5 1 5
            int distB = Math.abs(x - b); // 11 9 4 3 6
            if(distA == distB){
                return a-b; // distances same sort them based on their numbers.
            }
            return distA-distB; // ascending order
        }); // [14,16,9,8,19,3,2,1] sorted Array based on distances

        List<Integer> result = new ArrayList<>();
        for(int i =0;i<k;i++){
            result.add(arrList.get(i));
        }
        Collections.sort(result);
        return result;
    }
}

// Approach : Fix the window and slide until the window size is k and during the slide (calculate the distance from left and right)
// Time : O(n-k) + O(k)
// Space : O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(high - low + 1 >k){
            int distL = Math.abs(x-arr[low]);
            int distR = Math.abs(x-arr[high]);

            if(distL > distR){
                low++;
            } else{
                high --;
            }
        }

        for(int i =low;i<low+k;i++){
            result.add(arr[i]);
        }

        return result;
    }
}

// Approach : Using Max Heap 
// Time : O(nlogk) + O(klogk) pop elements from heap + O(klogk) sort
// Space : O (logk)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{ // index 0 - distance and index 1 as num
            if(a[0] == b[0]){
                return b[1]-a[1];
            }
            return b[0] - a[0]; // Descending order
        });

        for(int i =0;i<arr.length;i++){
            int distL = Math.abs(x-arr[i]);
            pq.add(new int[]{distL,arr[i]});
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.poll()[1]);
        }
        Collections.sort(result);
        return result;
    }
}

// Approach : Using Binary Search we try to identify the starting range
// Time : log(n-k) + O(k)
// Space : O()
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low =0;
        int high = n-k;

        while(low<high){
            int mid = low + (high-low)/2; // this will be used to find the correct starting range

            // initially consider this mid as correct starting range and calcualate distance
            int distS = x-arr[mid];
            int distE = arr[mid+k] -x;

            if(distS > distE){
                low = mid+1;
            } else{
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i =low; i<low+k;i++){
            result.add(arr[i]);
        }  

        return result;      
    }
}