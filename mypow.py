#Time COmplexity : O(Log(n)) where N is is the power so every time we divide n by half
#Space COmplexity : O(Log(n)) where N is the number f time is stored in stack
class Solution:
    def myPow(self, x: float, n: int) -> float:
     
            if n ==0 :
                return 1
    
            temp = self.myPow(x,int(n/2))
        
            if n%2 ==0:
                return temp*temp
            else:
                if n < 0:
                    return temp*temp*(1/x)
                else:
                    return temp*temp*(x)