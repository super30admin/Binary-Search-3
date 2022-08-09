//Time Complexity:Lineary search + k elements = O(n)+O(k)

//Space Complexity:O(1)
//Microsoft
//here k = number of elements in output to return and x = 14  then take the difference of every elements.Based upon my distance using binary search pick the smaller element that will be closest to binary search.Don't give me list give me starting index, how to do a binary where i dont have to do binary search but locate the element .
//end distance is greater than start and start locating where to pick the element.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        
        //Binary search for the starting index
        int n = arr.length;
        int low = 0;
        int high = n-k;
        int mid = 0;
        
        while(low<high){
            mid = low +(high-low)/2;
            int distStart = x-arr[mid];
            int distEnd = arr[mid+k]-x;
            if(distStart>distEnd){
                low = mid+1;
            } 
            else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low;i<low+k;i++){
            //for(int i = high;i<high+k;i++)
            result.add(arr[i]);
        }
          return result;
    }
   
}