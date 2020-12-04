#Brute force solution to solve the problem
#Time compelxity: O(3n)
#Space complexity: O(2n)
import itertools 
from itertools import permutations  
maxTravelDist = 7000
forwardRouteList = [(1,2000),(2,4000),(3,6000)]
returnRouteList = [(91,2000)]
def travel(forwardRouteList,maxTravelDist,returnRouteList):
    plist = itertools.permutations(forwardRouteList, len(returnRouteList))
    li = list()
    for combination in plist: 
        combined = zip(combination, returnRouteList)
        li.append(list(combined)) 

    li2 = list()
    for elem in li:
        e1  = elem[0][0]
        e2 = elem[0][1]
        li2.append((e1[0],e2[0],e1[1]+e2[1]))

    max = (0,0,0)
    for el in li2:
        if el[2] > max[2] and el[2]<maxTravelDist:
            max = el
    print(max)
            

travel(forwardRouteList,maxTravelDist,returnRouteList)

