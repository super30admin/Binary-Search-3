class Solution(object):
	def myPow(self, x, n):
		"""
		:type x: float
		:type n: int
		:rtype: float
		"""
		# what is the time complexity of this?
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

	def myPow(self, x: float, n: int) -> float:
		# Time Complexity : O(logn) because we are dividing the value of n into half
		# When the value of n is even we just return temp^2
		# If its odd we have to check for the n value if n < 0 then return temp^2*1/x else return temp^2
		if n == 0:
			return 1
		temp = self.myPow(x, int(n/2))
		if n%2 == 0:
			return temp * temp
		else:
			if n > 0:
				return temp * temp * x
			else:
				return temp * temp * 1/x