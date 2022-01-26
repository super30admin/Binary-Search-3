class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l = 0
        r = len(arr)
        m = (l + r)/2
        # l_mid = None
        while l <= r:
            mid = int((l + r) / 2)
            # print(mid)
            if arr[mid] == x:
                
                break
            if x < arr[mid]:
                if mid > 0 and arr[mid - 1] < x:
                    mid = mid - 1 if abs(x - arr[mid-1]) < abs(arr[mid] - x) else mid
                    break
                if mid == 0:
                    break
                r = mid
            else:
                if mid < len(arr) - 1 and arr[mid + 1] > x:
                    mid = mid if abs(x - arr[mid]) < abs(arr[mid+1] - x) else mid + 1
                    print("here")
                    break
                if mid == len(arr) - 1:
                    break
                l = mid + 1
        print(mid)
        # return []
        # mid = bisect_left(arr, x) - 1
        final = []
        # final.append(arr[mid])
        print(mid)
        left = mid - 1
        right = mid
        while right - left - 1 < k:
            if left < 0:
                # final.append(arr[right])
                right += 1
                continue
            
            if right == len(arr) or abs(arr[left] - x) <= abs(arr[right] - x):
                # final = [arr[left]] + final
                left -= 1
            else:
                # final.append(arr[right])
                right += 1

        
        return arr[left+1:right]




# from heapq import heapify, heappush, heappop
# class Solution:
#     def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
#         heap = []
#         heapify(heap)
#         hash_ = {}
#         for ele in arr:
#             temp = abs(x-ele)
#             if temp not in hash_:
#                 hash_[temp] = [ele]
#                 heappush(heap,temp)
#             else:
#                 hash_[temp].append(ele)
            
        
#         final = []
#         prev = -1
#         while len(final) < k:
#             temp = heappop(heap)
#             final += hash_[temp]
#         final = final[:k]
#         final.sort()
#         return final
            