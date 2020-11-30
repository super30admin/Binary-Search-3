#Simple recursive approach to implem ent pow function
#Time complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def calc(self,num,raisedto):
        num = self.helper(num,raisedto)
        print(num)
    def helper(self,number,i):
        if i == 1:
            return number
        else:
            print(number)
            return number * self.helper(number,i-1)

s = Solution()
s.calc(2,4)