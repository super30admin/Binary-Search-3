class Solution(object):
	def myPow(self, x, n):
		"""
		:type x: float
		:type n: int
		:rtype: float
		"""
		return x ** n

	def myPow(self, x, n):
		"""
		:type x: float
		:type n: int
		:rtype: float
		"""
		# This gave me a memory error
		# Because I have a loop which runs n times
		isNeg = False
		if n < 0:
			isNeg = True
			n *= -1
		res = 1
		for i in range(n):
			res *= x
		if isNeg:
			res = 1/res
		return res