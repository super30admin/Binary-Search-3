Exected in LeetCode- Yes
time Complexity- O(logn)

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0) return 1;
        if(n%2==0) return isPowerOfTwo(n/2)*isPowerOfTwo(n/2);
        else {
            if(n >0)
                return isPowerOfTwo(n/2)*isPowerOfTwo(n/2)*2;
            else
                 return isPowerOfTwo(n/2)*isPowerOfTwo(n/2)*1/2;
        }
    }
}
