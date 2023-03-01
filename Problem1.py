#Time complexity :_ O(log n )
# Space Complexity :- O(log n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n ==0:
            return 1
        
        answer = self.myPow(x,n//2 if n>0 else int(n/2))
        if n%2==0:
            return answer * answer
        else:
            if n>0:
                return answer * answer * x
            else:
                return answer * answer * (1/x)