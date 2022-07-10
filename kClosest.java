class Solution {
//2 pointer solution , TC: O(n-k) SC:O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        
        int low=0;
        int high=arr.length-1;
        if(low==high){result.add(arr[low]);return result;}
        while(high-low+1!=k){
            if(Math.abs(x-arr[low])>Math.abs(x-arr[high]))
                low++;
            else if(Math.abs(x-arr[low])<Math.abs(x-arr[high]))
                high--;
            else{
                
                high--;
            }
        }
        
        for(int i=low;i<=high;i++){
            result.add(arr[i]);
        }
    return result;
}
}
