# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)
Approach:
1. Used Recursive appraoch by minimizing the multiplications. e.g. X^10 can also be written as x^2^5. It directly makes the multiplication count to half. 
2. pow(x*X, n/2). As the multiplicative facor increases, value of n becomes half. Just. in case of odd power, we have to multiply by x one more time.
3. Retunr the result.

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
Approach:
1. Create a TreeMap of Integer and LinkedList<Integer> to Store the distance from x and its corresponding elements from the array. Took TreeMap so that we I can sort it according to distance.
2. Fill the treemap with distance and its corresponding elements.
3. Traverse the treemap and add first k elements from the linkedlist to the resultList.
4. Return resultlist.


## Problem3
Optimize Air Routes (https://leetcode.com/discuss/interview-question/318918/amazon-online-assessment)
Discussion not found.

