#Problem 2:Amazon optimise routes problem
#Test Cases passed on Leetcode 
#Binary Search Used
#Time Complexity-O(m+n)
#Space Complexity-O(1)--no auxilliary space

class Solution:
    def optimise(self,F,B,allowed_fuel):
        low=0
        high=len(B)-1
        max_dist=0
        result=[[]]
        while low <= len(F)-1 and  high >= 0: 
            dist_low = F[low][1]
            dist_high = B[high][1]
            sum_dist = dist_low + dist_high
            #if the sum distance is same as max dist till now, simply append in the result
            if sum_dist == max_dist:
                result.append([F[low][0],B[high][0]])
                low+=1
                high-=1
            #if sum distance found is more than max distance till now, remove all the previous values 
            #Append new values in the resultant areas which give us more distance
            if sum_dist <= allowed_fuel and sum_dist > max_dist:
                max_dist = sum_dist;
                result.clear()
                result.append([F[low][0],B[high][0]])
                low+=1
                high-=1
            #Otherwise if sum_dist is not more than max_dist till now
            #simply increment low pointer
            elif sum_dist < allowed_fuel:
                low+=1
            else:
            #if sum dist is larger than allowed fuel,decrement high pointer
                high-=1
        return result
    
sol=Solution()
F=[[1,2000],[2,3000],[3,4000]]
B=[[1,2000],[2,3500],[3,5000]]
allowed_fuel=7000
result=sol.optimise(F,B,allowed_fuel)