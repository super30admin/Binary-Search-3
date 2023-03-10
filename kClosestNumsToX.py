    #All TC on leetocde passed


class Solution:
    
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        #binary search approach. Here we find the index of starting point of result. Once we find the potential starting index then return arr from starting point to (starting point + k) 
        #Time complexity - O(log(n-k))
        #Space complexity - O(1)

        l=0             #Min possible start point
        h=len(arr)-k    #Max possible start point

        while l<h:
            mid = (l+h)//2

            distS = (x-arr[mid])
            distE = (arr[mid+k]-x)
            if distS>distE:
                l = mid+1
            else:
                h = mid
                
        return arr[l:l+k]

#------------------------------------------OR----------------------------------------------------

        
        #binary search approach. Here we find the index of x or closer number in the array and palce are l and h pointers on either side. Nums of pointers l and h are added to res
        #Time complexity - O(logn) + k
        #Space complexity - O(1)
        l=0
        h=len(arr)-1

        res = collections.deque()

        while l<=h:
            mid = (l+h)//2

            if arr[mid]==x:
                l=mid
                h=mid-1
                break
            elif arr[mid]>x:
                h = mid-1
            else:
                l = mid+1
        
        l,h = h,l
        
        i = 0
        while i<k:
            if l<0:
                res.append(arr[h])
                h+=1
            elif h>=len(arr):
                res.appendleft(arr[l])
                l-=1
            elif abs(arr[l]-x)<=abs(arr[h]-x):
                res.appendleft(arr[l])
                l-=1
            else:
                res.append(arr[h])
                h+=1
            i+=1
        
        return res
                


#------------------------------------------OR----------------------------------------------------


        #2 pointer approach
        #Time complexity - O(n)
        #Space complexity - O(1)
        l = 0
        h = len(arr)-1

        while h-l+1>k:
            if abs(x - arr[l]) <= abs(x - arr[h]):
                h-=1
            else:
                l+=1

        return arr[l:h+1]

#------------------------------------------OR----------------------------------------------------


         #Here we create an array with difference of each item in arr with x. Then we add these differences to maxHeap of size k. maxHeap stores k closest elements these are poped and sorted.
        #Time complexity - O(nlogk + klogk) - pushing into heap and sorting the result
        #Space complexity - O(n+k) - for holding the differences
        diff = [(0,0)]*len(arr)
        
        for i in range(len(arr)):
            diff[i] = (-1*abs(x-arr[i]), -1*arr[i])
        
        maxHeap = []

        for i in range(len(diff)):
            heapq.heappush(maxHeap, diff[i])
            if len(maxHeap)>k:
                heapq.heappop(maxHeap)
        res = []
        
        for i in range(k):
            diff, val = heapq.heappop(maxHeap)
            res.append(-1*val)
        
        res.sort()
        return res

#------------------------------------------OR----------------------------------------------------



        #Here we create an array with difference of each item in arr with x and sort it. After sorting we choose the smallest k elements and add it to result and return the sorted result again
        #Time complexity - O(nlogn + klogk) for sorting differences and sorting the result
        #Space complexity - O(n) - for holding the differences
        diff = [(0,0)]*len(arr)

        for i in range(len(arr)):
            diff[i] = (abs(x-arr[i]), arr[i])
        
        diff.sort(key = lambda x:x[0])

        res = sorted([diff[i][1] for i in range(0,k)])
        
        return res
        

        


        

        