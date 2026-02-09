//
//  PowerXN.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/6/26.
//

/*
 find pow(x,n) -> x^n - develop this function
 bruteforce - multiple x by n times - time complexity - O(n)
 pow(3, -4) = 1/3 * 1/3 * 1/3 * 1/3 =

 Approach 2-
 2 ^ 7 =
 divide the power into half.
 in case of odd power, extra 2 will be coming up
 in case of even power, extra 2 wouldn't be coming up
 
 either recursive or iterative
 time compelxity -> O(log n)
 space complexity - log n
 
 
 Approach 3 -> when we don't want to use recursiion stack and avoid space complexity
 */

class PowXN {
    init() {
        
        
    }
    /*
     time complexity - log n
     space compelxity - O(1)
     */
    func myPow(_ x: Double, _ n: Int) -> Double {
        var x = x
        var n = n
        if (n < 0) {
            x = 1 / x
        }
        var result: Double = 1.0
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x
            }
            n = n / 2
            x = x * x
        }
        return result
    }
    
    //solution 2
    /*
     time compelxity - log(n)
     space compelxity - log n
     */
     func myPow2(_ x: Double, _ n: Int) -> Double {
             //base
             if (n == 0) {
                 return 1.0
             }
             let r: Double = myPow(x, n / 2)
             var result: Double
             if (n % 2 == 1 || n % 2 == -1) {
                 if (n < 0) {
                     result =  r * r * (1 / x)
                 } else {
                     result = r * r * x
                 }

             } else {
                 result =  r * r
             }
             return result
        }

}
