class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
        int low= 0;
        int high = n-1;
        while(high- low + 1 >k){
            int distL = Math.abs(arr[low]-x);
            int distH = Math.abs(arr[high]-x);
            if(distL> distH) low++;
            else high--;
        }
         List<Integer> result= new ArrayList<>();
        for( int i= low; i<= high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

//Time complexity- O(n)
//Space complexity- O(k)

//solution discussed in class 

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
        int low= 0;
        int high = n-k;
        while(low< high){
            int mid = low+ (high-low)/2;
            int distS = x- arr[mid];
            int distL = arr[mid+k]-x;
            if(distS> distL) low= mid+1;
            else high = mid;
        }
         List<Integer> result= new ArrayList<>();
        for( int i= low; i< low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

//Time complexity - O(log(N)+k)
// Space complexity- O(k)