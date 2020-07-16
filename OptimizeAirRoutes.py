-------------------------------- Optimize Air Routes ---------------------------------------------
# Time Complexity : mlogm+nlogn
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# first I have sorted both the arrays with amount for the trip. Once sorted , I will use 2 pointer one start at the start of forward
# and other start at the end of the backward arrays. we will iterate through elements until we reach all the elements.
# we will take the elements at pointers and add the total amount. If the total added value is equal <= total value. add them to the temp
# and it value is equal we will increment first pointer and decrement second, if less than total increment first pointer, else decrement second pointer.
# then i will sort the values based on the amount in decrement. Then I took the maximum value trips iterating through them.

def optimizeRoutes(total, forward, backward):
    if not total or not forward or not backward:
	    return None
    forward.sort(key = lambda p:p[1]) # MlogM
    backward.sort(key = lambda p:p[1]) # N log N
	
    low = 0
    high = len(backward)-1
	
    temp = []
    while 0<=low<len(forward) and 0<=high<len(backward):
	    f = forward[low]
	    b = backward[high]
	    if f[1]+b[1] <= total:
	        temp.append([f[0], b[0], f[1]+b[1]])
	   
	    if f[1]+b[1]==total:
	        high -=1
	        low+=1
	    elif f[1]+b[1]<total:
	        low +=1
	    else:
	        high-=1
	 
    temp.sort(key = lambda p: -p[2])
    
    res = []
    if temp:
        res.append([temp[0][0], temp[0][1]])
        m = temp[0][2]
    for i in range(1,len(temp)):
        if temp[i][2] == m:
            res.append([temp[i][0], temp[i][1]])
    return res

res = optimizeRoutes(6000, [[1,4000],[2,2000],[3,6000]], [[1,4000], [2,2000], [3,2800]])
print(res)