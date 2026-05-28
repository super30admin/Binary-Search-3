//Time Complexity : O(nlog(k))
// Space Complexity: O(k)
//using heap sol -
/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result= new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int disA= Math.abs(a-x);
            int disB= Math.abs(b-x);
            if(disA==disB) return b-a;
            else return disB-disA;
        });
        //max heap bcs we are storing the top 4 lowest values and removing bigger values 
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k) pq.poll();
        }
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}
*/ 

// intermediate sol - 
// using 2 pointers 
//Time Complexity : O(n)
// Space Complexity: O(1)
/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result= new ArrayList<>();
        int l=0;
        int h = arr.length-1;
        while(h-l+1>k){
            // int mid=l+(h-l)/2;
            int disA= Math.abs(arr[l]-x);
            int disB= Math.abs(arr[h]-x);
            if (disA > disB) {
                l++;
            } else {
                h--;
            }
        }
        for(int i=l;i<=h;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
*/

//Most optimal sol -
//binary search 
// Time complexity : O(logn+k)
//Space Complexity : O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result= new ArrayList<>();
        int l=0;
        int h = arr.length-1;
        while(l<h){
            int mid=l+(h-l)/2;
            if(arr[mid]<x) l=mid+1;
            else h=mid;
        }
        l=h-1;
        while(k>0){
            if(l<0) h++;
            else if (h >= arr.length || Math.abs(arr[l] - x) <= Math.abs(arr[h] - x)) l--;
            else h++;
            k--;
        }
        for (int i = l + 1; i < h; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}

// follow up - find me the range for the numbers rather the closest values 
