# Time Complexity: O(n-k)+O(k)= O(n)
# space complxity: O(1)
# Leetocode Execution: YES
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low=0
        high=len(arr)-1
        # logic is to move elements from both ends. first bring them at similar level then move high when they are same else only low
        while(high-low>=k):
            
            # to bring low and high at similar distance we first computer their ditance from x than we move high and low accordingly 
            distlow=x-arr[low]
            disthigh=arr[high]-x
            if disthigh>=distlow:
                high-=1
            else:
                low+=1
        # when high and low are at the position we need we just then move low to towards high and append all the elements in the lost we have planned to return 
        result=[]
        while(low<=high):
            result.append(arr[low])
            low+=1
        return result
            
                
        
