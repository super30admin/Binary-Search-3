class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(M+N) [Size of Arrays]
        Space: O(1)
        
    """
    def optimize_routes(self, forward, backward, milage):
        
        low = 0
        high = len(backward)-1
        res = []
        m = milage + 1
        
        while(low<len(forward) and high>-1):
            # print(low, high)
            val = forward[low][1] + backward[high][1]
            if val < m:
                res = []
                res.append([forward[low][0], backward[high][0]])
            elif val == m:
                res.append([forward[low][0], backward[high][0]])
            if low != len(forward)-1 and milage - backward[high][1]>=forward[low+1][1]:
                low += 1
            else:
                high -= 1
            
            
        return res
    
    

driver = Solution()

forward = [[1, 2000], [2,4000], [3, 6000]]
backward = [[1, 3000], [2, 2500], [3, 5000]]
m = 7000

print(driver.optimize_routes(forward, backward, m))
