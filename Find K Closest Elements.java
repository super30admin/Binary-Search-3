// Time Complexity : O(n+k) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        //check for null or empty arr case
        if(arr == null || arr.length == 0) return result;
        //keep two pointers : first and last 
        //and loop till elements between them is size k 
        int first = 0;
        int last = arr.length-1;
        while(last - first + 1 > k) {
            //check which pointer to move
            //if diff between last element and x is larger
            //than the diff between x and first element
            //inc last
            //else inc first
            if((arr[last] - x) >= (x - arr[first])) {
                last--;
            }
            else {
                first++;
            }
        }
        
        //add the elements between first and last to result list
        //and return result
        for(int i = first; i <= last; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

//////////////////


// Time Complexity : O(log (N-k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//TC : O(log(n-k)+k) 
//Binary Search is done for n-k elements (high points to n-k)
//O(k) to add elements to result
//SP : O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //result list
        List<Integer> result = new ArrayList<>();
        //check for null or empty arr 
        if(arr == null || arr.length == 0) return result;
        //set low = 0 and high = length - k 
        //to keep a length of k elements if high is at the first element in the result
        //to avoid missing the elements if last k elements is the answer
        int low = 0;
        int high = arr.length-k;
        //loop till low < high
        //move high to mid, as we dont check for mid, so to check mid, we move high to mid
        while(low < high) {
            int mid = low + (high-low)/2;
            //if diff between x and mid element is larger
            //than the diff between mid+kth element and x 
            //then we know soln lies after mid, so move low
            if((x - arr[mid]) > (arr[mid+k] - x)) {
                low = mid+1;
            }
            else {
                //else move high to mid
                high = mid;
            } 
        } //low will always point to the first element of the result 
        //add the elements between low and low+k to result list
        //and return result
        for(int i = low; i < low+k; i++) {
            result.add(arr[i]);
        }
        return result;
        
    }
}

//////////////


// Time Complexity : O(nlogn) , n is array length
// Space Complexity : O(n), heap size 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Using Custom comparator : MinHeap as a pair (Number, Diff(mod(no - x)))
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //create a result list
        List<Integer> result = new ArrayList<>();
        //Priority Queue using custom comparator
        // for each element "i" in the array, create a pair <Number, difference>
        //Pair : pair[0] = number, pair[1] = difference
        //create a minHeap based on this pair 
        //sort using difference, if difference is equal, sort using number
        //(a-b), a-b --> minheap, a: in PQ, b: new element
        //if a-b = -ve : a is smaller, so a gets priority, so b is added before a in Heap
        //if a-b = +ve : b is smaller, so b gets priority, so a is added before b in heap
        PriorityQueue<int []> minHeap= new  PriorityQueue<>((a,b)->(a[1]==b[1]) ? a[0]-b[0] : a[1]-b[1]) ; 
        //iterate through the array
        //adding all elements : as keeping size k or adding all elements : takes same time
        for ( int i=0;i< arr.length;i++){
            int [] pair = new int[2];
            pair[0]=arr[i];
            pair[1]= Math.abs(x-arr[i]);     
            minHeap.add(pair);
        }    
        //add top k elements to result list
        while(k > 0){
            int [] pair = minHeap.remove();
            result.add(pair[0]);
            k--; 
        }    
        //sort the list and return
        Collections.sort(result);
        return result;
    }
}

/*
1,2,3,4,5 
diff : 2,1,0,1,2
so min heap = 0,1,1,2,2  => 3,2,4,1,5
so take first 4 as k = 4
*/
