//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res= new ArrayList();
        int n= arr.length;
        int left= 0; int right=n-1;
        while((right-left+1)>k)
        {
            int a= Math.abs(arr[left]- x);
            int b= Math.abs(arr[right]-x);
            if(a>b)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        for(int i=left;i<=right;i++)
        {
            res.add(arr[i]);
        }
        return res;
    }
}