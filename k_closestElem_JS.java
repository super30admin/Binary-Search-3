/*Running Time Complexity: O(n-k)
Space Time Complexity: constant
Successfully Run and Compiled on leetcode
*/
class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(arr==null || arr.length==0) return list;
        int low = 0; int high = arr.length-k;
        
        while (low<high){
            int mid = low + (high-low)/2;
            int fside = x-arr[mid];
            int lside = arr[mid+k] - x;
            if(fside>lside){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        for(int i=low;i<low+k;i++){
            list.add(arr[i]);
    }
        return list; 
    }
}

/*
Another Solution 
class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(arr==null || arr.length==0) return list;
        int low = 0; int high = arr.length-1;
        
        while (high-low+1>k){
            int Lside = Math.abs(x-arr[low]);
            int Hside = Math.abs(x-arr[high]);
            if(Lside>Hside){
                low++;
            }else{
                high--;
            }
        }
        
        for(int i = low;i<=high;i++){
            list.add(arr[i]);
    }
        return list;
    }
}


*/