class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result= new ArrayList<>();
        
        int low=0;
        int high= arr.length-1;
        
        while(high-low+1 >k){
            int distR= Math.abs(arr[high]-x);
            int distL= Math.abs(arr[low]-x);
            
            if(distR>= distL)
                high--;
            else low++;
        }
        
        for(int i=low;i<=high;i++)
            result.add(arr[i]);
        
        return result;
    }
}
