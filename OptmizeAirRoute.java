
import java.util.*;

public class OptimizeAirRoute {
	public List<int[]> optimizeArrayRoute(int[][] forward, int backward[][], int maxTraverseList) {
		List<int[]> output = new ArrayList<>();

		if (forward == null || forward.length == 0 || backward == null || backward.length == 0) {
			return output;
		}
		int size1 = forward.length;
		int size2 = backward.length;
		int maxDistanceSoFar = 0;
		for (int forw[] : forward) {
			for (int back[] : backward) {
				int currentDistance = back[1] + forw[1];
				if (currentDistance < maxTraverseList) {
					maxDistanceSoFar = Math.max(maxDistanceSoFar, currentDistance);
					output.add(new int[] { forward[0][0], backward[0][0] });
				}
			}
		}
		return output;
	}

	public static void main(String args[]) {
		int forward[][] = {{1,2000},{2,4000},{3,6000}};
		int backward[][] = {{1,2000}};
		int maxTravelList= 7000;
		
		OptimizeAirRoute airRoute = new OptimizeAirRoute();
		System.out.println(airRoute.optimizeArrayRoute(forward, backward, maxTravelList));
	}
}