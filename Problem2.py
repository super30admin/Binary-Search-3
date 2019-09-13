class Solution(object):
	def findClosestElements(self, arr, k, x):
		"""
		:type arr: List[int]
		:type k: int
		:type x: int
		:rtype: List[int]
		"""
		# Time Complexity : O(nlogn) because of sorting of the array
		# Accepted on leetcode
		res = arr[:]
		res.sort(key=lambda i:abs(i - x))
		res = res[:k]
		res.sort()
		return res

	def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
		# Time Complexity : O(n - k) because we don't check the k elements that lie between our low and high pointer
		low = 0
		high = len(arr) - 1
		while high - low + 1 > k:
			if abs(arr[low] - x) > abs(arr[high] - x):
				low += 1
			else:
				high -= 1
		return arr[low:high + 1]

	def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
		# Time Complexity : O(log(n - k)) because we use binary search to find the correct position of our low pointer and initially the right pointer is place at len(arr) - k because we have to verify only the n - k elements
		low = 0
		high = len(arr) - k
		while low < high:
			mid = low + (high - low)//2
			if abs(arr[mid] - x) > abs(arr[mid + k] - x): # Here we check the mid and mid + k because our correct position for low pointer will be in between mid and min + k locations
				low = mid + 1
			else:
				high = mid
		return arr[low:low + k]