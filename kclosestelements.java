//Time complexity:O(n)
//Space complexity:O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList();
        int low=0;
        int high=arr.length-1;
        while(high-low>=k){
            int left=Math.abs(arr[low]-x);
            int right=Math.abs(arr[high]-x);
            if(left<=right){
                high--;
            }
            else{
                low++;
            }
        }
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}