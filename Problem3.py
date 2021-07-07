# Time Complexity : O((M+N)logM)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class RouteInfo:

    def __init__(self, id, route):
        self.id = id
        self.route = route

    #   custom =, <, <=, >, >=, != operators defined for the class
    def __eq__(self, new):
        return self.route == new.route
    
    def __ne__(self,new):
        return self.route != new.route
    
    def __lt__(self,new):
        return self.route < new.route
        
    def __le__(self,new):
        return self.route <= new.route
    
    def __gt__(self,new):
        return self.route > new.route
    
    def __ge__(self,new):
        return self.route >= new.route

    def __repr__(self):
        return '%d %d' % (self.id,self.route)
    
class Solution:
    def airRoute(self,F,B,target):
        result = []
        if len(F) < 1 or len(B) < 1 :
            return result
        if len(B) > len(F):
            self.airRoute(B, F, target)
        B.sort()
        maxValue = float('-inf')
        
        for i in range(len(F)):
            diff = target - F[i].route 
            indx = self.__binarySearch(B, diff)
            if indx != -1 :
                currSum = F[i].route + B[indx].route
                if currSum >= maxValue:
                    if currSum > maxValue:
                        result = [] # resetting 
                    maxValue = max(maxValue, currSum)
                    result.append([F[i].id, B[indx].id])

        return result              
    
    def __binarySearch(self, arr, target):
        low = 0 
        high = len(arr) - 1 
        
        while low <= high:
            mid  = (low+high)//2
            
            if arr[mid].route == target:
                return mid 
            
            elif arr[mid].route < target:
                low = mid + 1 
            
            else:
                high = mid - 1 
        
        return high
 
if __name__ == "__main__":
    s = Solution()
    F = [RouteInfo(1, 4000), RouteInfo(2, 2000), RouteInfo(3, 6000)]
    B = [RouteInfo(1, 1000), RouteInfo(2, 2500), RouteInfo(3, 2800)]
    target = 7000
    res = s.airRoute(F,B,target) 
    print(res)