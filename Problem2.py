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