# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

# Check if n is negative and x is '0' we return infinite else change x to 1/x and reverse sign of n
# Check edge cases where n is '0' we return 1 and if n is '1' we return the value x
# Recursively call the function to operate on half of the power n/2 and use the result to multiply with 
# itself in case of even power to return result else if the power is odd we multiply it by x.


## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

# Initialize the low with '0' and high as length of array - k elements
# Binary search - Find the mid element taking the average of low and high
# Calculate the start distance as x minus the mid element and end distance as mid + k element minus x
# If start distance is greater than the end distance we move the low to mid + 1 element else move high
# to mid element and perform the Binary search again until the low and high cross eachother.
# Return the result array with elements between low and low + k.




