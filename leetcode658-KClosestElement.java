//Approach
/*
Two pointers : 
1. Left pointer, right pointer
2. if X -arr[left] <= arr[right] - X; right--;
3. else left++;
4. run these loop in while until right-left+1 >k ; that means when we get equality here, that means we're in a range of K elements we wanted. 
return those new elements in the form of arraylist!

TC: O(n-k)
sc: O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //base case
        if(arr == null || k ==0 ) return new ArrayList<>(){};
        
    
        //take two pointers left and right
        int left = 0;
        int right = arr.length -1;
        
        while(right -left +1 > k)
        {
            //check whose dstance is more and move that pointer
            if(arr[right] - x >= x - arr[left])
                right--;
            else
                left++;
        }
        
        List<Integer> result =  Arrays.stream(arr, left, right+1).boxed().collect(Collectors.toList());
        return result;
    }
}