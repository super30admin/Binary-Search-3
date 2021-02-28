# -*- coding: utf-8 -*-
"""
Created on Wed Dec 30 12:50:50 2020

@author: Tripti Santani

https://leetcode.com/discuss/interview-question/373202

"""

class routes:
    
    def optimalRoutes(self,forward,backward,target):
        
        output = []
        if forward == None or backward == None or target == 0:
            return output
        maximum = 0
        # Sorting backward array
        def sortSecond(val):
            return val[1]
        backward.sort(key=sortSecond)
        #print(backward)
        
        #Iterate through the forward list
        for i in range(len(forward)):
            index = self.binarySearch(backward,target-forward[i][1])
            #print(index)
            total = forward[i][1]+backward[index][1] 
            
            if total>=maximum and total <= target:
                if total>maximum:
                    output=[]
                    
            maximum = total
            output.append([forward[i][0],backward[index][0]])
            
        return output
    
    def binarySearch(self,backward,target):
        
        if backward == None:
            return 0
        
        left = 0
        right = len(backward)-1
        while(left<=right):
            mid=int(left+(right-left)/2)
            if backward[mid][1]==target:
                return mid
            elif backward[mid][1]<target:
                left=mid+1
            else:
                right=mid-1
                
                
        return right
       
    
    
forward = [[1, 3], [2, 5]] #a-b
backward = [[1, 2], [2, 3]] #b-a
target = 7
obj=routes()

print(obj.optimalRoutes(forward,backward,target))