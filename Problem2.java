import java.util.*;

class Problem2 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return findStartIndexBS(arr,k,x);
    }

    //TC: O(nlogk) + 2klogk(one for sorting and one for popping k elements)
    //SC : O(k)
    public List<Integer> findUsingMaxHeap(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{if(a[1]==b[1]){
            return b[0]-a[0];
        }else{
            return b[1]-a[1];
        }

        });
        for(int i =0;i<arr.length;i++){
            pq.add(new int[] {arr[i],Math.abs(arr[i]-x)});
            if(pq.size()>k){
                pq.poll();
            }

        }
        while(!pq.isEmpty()){
            result.add(pq.poll()[0]);
        }
        Collections.sort(result);
        return result;
    }
    //TC O(log(n))
    //SC O(1)
    public List<Integer> findStartIndexBS(int[] arr, int k, int x) {
        // binary search and find the start index and add k to it

        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length -k;
        //TC O(log(n))
        while(low<high){
            int mid = low + (high -low)/2;
            int sd = x - arr[mid];
            int ed = arr[mid+k] -x;
            if(sd>ed){
                low = mid+1;
            }else{
                // we cannot ignore an element so inclde it as it can be part of the result
                high = mid;
            }
        }
        //TC:O(K) if it was not for element and just the range we would not have to use this block
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        //
        return result;
    }


}