class Solution:
	def OptimizedAir1(self, maxTravelDist, forwardRouteList, returnRouteList):
		# Brute Force Way
		# Using more space for storing all the differences
		mapDistance = dict()
		for i in forwardRouteList:
			if i[1] > maxTravelDist:
				continue
			for j in returnRouteList:
				if j[1] > maxTravelDist - i[1]:
					continue
				totalDist = maxTravelDist - (i[1] + j[1])
				if totalDist not in mapDistance:
					mapDistance[totalDist] = []
				mapDistance[totalDist].append((i[0], j[0]))
		sortedKeys = sorted(list(mapDistance.keys()))
		for i in sortedKeys:
			if i < 0:
				continue
			return mapDistance[i]

	def OptimizedAir2(self, maxTravelDist, forwardRouteList, returnRouteList):
		# Brute force way
		# Time Complexity : O(nm) where n is the length of the forwardRouteList and m is the length of returnRouteList
		maxDist = -1
		maxDistlist = []
		for i in forwardRouteList:
			if i[1] > maxTravelDist:
				continue
			for j in returnRouteList:
				if j[1] > maxTravelDist - i[1]:
					continue
				totalDist = i[1] + j [1]
				if totalDist >= maxDist:
					if totalDist > maxDist:
						maxDistlist = []
						maxDist = totalDist
					maxDistlist.append((i[0], j[0]))
		return maxDistlist

	def OptimizedAir3(self, maxTravelDist, forwardRouteList, returnRouteList):
		# Using the binary search to find the nearest value to the compliment
		# Time Complexity : O(nlogn)[sort forwardRouteList] + O(mlogm)[sort returnRouteList] + O(nlogm) [Iterating through the forwardRouteList and finding the closest value to the compliment from the returnRouteList using binary search]
		forwardRouteList.sort(key = lambda x:x[1])
		returnRouteList.sort(key = lambda x:x[1])
		maxDist = -1
		maxDistlist = []
		for i in forwardRouteList:
			compliment = maxTravelDist - i[1]
			nearest = self.getNearestDist(returnRouteList, compliment)
			if nearest != -1:
				totalDist = i[1] + returnRouteList[nearest][1]
				if totalDist >= maxDist:
					if totalDist > maxDist:
						maxDistlist = []
						maxDist = totalDist
					maxDistlist.append((i[0], returnRouteList[nearest][0]))
		return maxDistlist

	def getNearestDist(self, arr, target):
		low = 0
		high = len(arr) - 1
		nearest = -1
		while low <= high:
			mid = low + (high - low)//2
			if arr[mid][1] == target:
				return mid
			elif arr[mid][1] > target:
				high = mid - 1
			else:
				nearest = mid
				low = mid + 1
		return nearest

if __name__ == '__main__':
	oa = Solution()
	print(oa.OptimizedAir1(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir1(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))
	print(oa.OptimizedAir2(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir2(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))
	print(oa.OptimizedAir3(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir3(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))