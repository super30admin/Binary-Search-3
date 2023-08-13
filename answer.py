1.Pow(x, n)

Time Complexity:O(log(n))
Space Complexity:O(1)
Leetcode:Yes

class Solution:
    def myPow(self, x: float, n: int) -> float:
        if(n<0):
            n=n*(-1)
            x = 1/x
        result = 1.0
        while(n!=0):
            if(n%2!=0):
                result=result*x
            x=x*x
            n=n//2
            print(n)
        return result




2.Find K Closest Elements
Time Complexity: O(log(n-k))
Space Complexity: O(1)
Leetcode: Yes

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr)-1
        while(high - low + 1 > k):
            distL = abs(arr[low] - x)
            distH = abs(arr[high] - x)
            if(distL>distH):
                low+=1
            else:
                high-=1
        result = []
        for i in range(k):
            result.append(arr[low+i])
        return result
