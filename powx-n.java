// //Recursive
// //Time Complexity: O(logn)
// //Space Complexity: O(logn): recursion stack
// class Solution {
//     public double myPow(double x, int n) {
//         //base
//         if(n==0) return 1.0;
//         //logic - half the n always
//         double re = myPow(x, n/2);
//         if(n<0){
//             x=1/x;
//         }
//         if(n%2 == 0){ //even
//             return re * re;
//         } else { //odd
//         return re * re * x;
//         }
//     }
// }

//Iterative
//Time Complexity: O(logn)
//Space Complexity: O(logn)
class Solution {
    public double myPow(double x, int n) {
       double re = 1.0;
       if(n < 0){
        x = 1/x;
       }
       while(n != 0){
        if(n%2 != 0){
            re = re * x;
        }
        x = x*x;
        n = n/2; //reduce search space by hald
       }
       return re;
    }
}
