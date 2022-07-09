// Time Complexity :O(log(n-k))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// 3 modified Binary Search tree (log(n-k))
// Think to use when sorted array and we have find range
// here we wont find the element or closest to the element
// we will use low and high and then calculate the mid and then range od element
// high is not the last element but (n-k) coz in worst case the element can be last k elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - k;
        while(low < high){
            int mid = low +  (high-low)/2;
            if((x - arr[mid]) > arr[mid + k] - x){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++){ //add to result
            result.add(arr[i]);
        }
        return result;
    }
}



/*
//2 pointers O(n-k)
// use it to compair the distance of x and then lastly compaire the distance 'k' between the two pointers
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while((r-l) + 1 > k){
            if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x)){ //compaire distance
                l++;
            }else{
                r--;
            }
        }
        List<Integer> result = new ArrayList<>();
        while(l<r+1){ //add to result
            result.add(arr[l]);
            l++;
        }
        return result;
    }
}
*/


/*
//Max heap solution (Nlogk)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        for(int i = 0; i < arr.length; i++){ //for getting the elements in the array
            pq.add(new int[]{arr[i], Math.abs(arr[i] - x)});
            if(pq.size() > k){ //max heap to remove the max distance
                pq.poll();
            }
        }
        
        //add into result
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int [] pair = pq.poll();
            result.add(pair[0]);
        }
        Collections.sort(result);
        return result;
    }
}
*/