// Any problem you faced while coding this : None
#Passed for the given test cases

// Your code here along with comments explaining your approach
we sort the route which is having less number of routes.with each element in the other route we apply binary search on the smallest route and find the route which is closest to the target.we then do the same procedure again to find the combination which is having route closest to the target.

# Time complexity --> o(m logm)+o(nlogm) (m is the length of the smallest array and n is the length of the remaining array)
# space complexity --> O(min(len(first array),len(second array))
from operator import itemgetter
class Solution:
    def optimise_air(self,maxtraveldist,forwardRouteList,returnRouteList):
        mini=float('-inf')
        result=[]
        t=0
        if len(forwardRouteList)>=len(returnRouteList):
            m=forwardRouteList
            n=returnRouteList
        else:
            m=returnRouteList
            n=forwardRouteList
            t=1
        n=sorted(n,key=itemgetter(1))
        for list1 in m:
            low=0
            high=len(n)-1
            while(low<=high):
                mid=int(low+(high-low)/2)
                val=n[mid]
                if list1[1]+val[1]<=maxtraveldist and list1[1]+val[1]>=mini:
                    mini=list1[1]+val[1]
                    low=mid+1
                else:
                    high=mid-1
        print(mini)
        for list1 in m:
            low=0
            high=len(n)-1
            while(low<=high):
                mid=int(low+(high-low)/2)
                val=n[mid]
                if list1[1]+val[1]==mini:
                    if t==1:
                        result.append([val[0],list1[0]])
                    else:
                        result.append([list1[0], val[0]])
                    low=mid+1
                elif list1[1]+val[1]<mini:
                    low=mid+1
                else:
                    high=mid-1
        print(result)


maxtraveldist=10000
forwardRouteList = [[1,3000],[2,7000],[3,5000],[4,10000]]
returnRouteList = [[1,2000],[2,5000],[3,3000],[4,3000]]
some=Solution()
some.optimise_air(maxtraveldist,forwardRouteList,returnRouteList)