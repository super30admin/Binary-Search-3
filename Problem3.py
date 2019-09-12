class Solution:
	def OptimizedAir(self, maxTravelDist, forwardRouteList, returnRouteList):
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

if __name__ == '__main__':
	oa = Solution()
	print(oa.OptimizedAir(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))