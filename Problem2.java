
//Time Complexity: O(n-k)+O(k) = O(n)
//Space Complexity: O(1)

//We can use two pointers to solve this problem. We can start with two pointers, one at the beginning of the array and the other at the end.
//We can then compare the absolute difference between the target value x and the elements at the two pointers.
//We can then move the pointer that has the larger absolute difference towards the center of the array until the size of the window is equal to k.
//Finally, we can return the elements in the window as the result.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //two-pointers
        int l=0,h=arr.length-1;
        while(h-l+1!=k){
            int disL=Math.abs(arr[l]-x);
            int disH=Math.abs(arr[h]-x);
            if(disL>disH)
                l++;
            else
                h--;
        }
        List<Integer> ans=new ArrayList<>();
        while(l<=h){
            ans.add(arr[l]);
            l++;
        }
        return ans;
    }
}