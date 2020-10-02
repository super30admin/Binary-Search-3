#https://leetcode.com/problems/find-k-closest-elements/
#// Time Complexity : O(lg n)
#// Space Complexity : O(1)
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# Math.floor needed in javascript vs in java numbers get rounded
#
#// Your code here along with comments explaining your approach
#
# you are trying to find the beginning of the k elements
# guess low and high, low = 0 and high = length - k
# adjust either left or right depending on whichever is closer to the mid element
# where mid element is floor(h + l / 2)
# continue til low >= high
#
# return answer which will be at index l up til index l + k

findClosestElements = (arr, k, x) ->
  l = 0
  h = arr.length - k

  while l < h
    mid = l + (h - l)//2

    L_D = Math.abs(x - arr[mid])
    R_D = Math.abs(x - arr[mid + k])

    if L_D > R_D
      l = mid + 1
    else
      if arr[mid] is arr[mid + k]
        l = mid + 1
      else
        h = mid

  output = []

  for i in [l...l+k]
    output.push(arr[i])

  output

#Input: arr = [1,2,3,4,5], k = 4, x = 3
findClosestElements([1,2,3,4,5], 4, 3)#/*?*/
#Output: [1,2,3,4]

