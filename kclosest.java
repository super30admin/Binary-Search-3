class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       
        List<Integer> result = new ArrayList<>();
        //edge
        if(arr == null || arr.length == 0)
            return result;
        
       int low =0;int high = arr.length - 1;
        while(high - low >=k){
            int distl = Math.abs(arr[low] - x);
            int distr = Math.abs(arr[high] - x);
            if(distl > distr)
                low++;
           else
                high--;
        }
        
        for(int i=low;i<=high;i++)
            result.add(arr[i]);
        return result;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
