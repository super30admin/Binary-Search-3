//Time complexity-O(n)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        int high=arr.length-1;
        List<Integer> output= new ArrayList<>();
        while(high-low>=k){
            if(Math.abs(arr[low]-x)>Math.abs(arr[high]-x))//findig the extreme points with k length according to difference with x
                low++;
            else
                high--;
        }
        for(int i=low;i<=high;i++)
            output.add(arr[i]);
        
        return output;
    }
}