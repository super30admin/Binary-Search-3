function optimalUtilization(maxTravelDist, forwardRouteLit, returnRouteList) {
    console.log("## --------------------------------------------------------->");
    console.log("## INPUT:", "maxTravelDist:", maxTravelDist,
        "\nforwardRouteLit:", forwardRouteLit,
        "\nreturnRouteList:", returnRouteList);

    let maxMiles = 0;
    let pairs = [];
    for (let i = 0; i < forwardRouteLit.length; i++) {

        let base = forwardRouteLit[i][1];

        for (let j = 0; j < returnRouteList.length; j++) {
            let value = returnRouteList[j][1];

            let total = base + value;
            if (total <= maxTravelDist) {
                if (total > maxMiles) {
                    maxMiles = total;
                    pairs = [];
                    console.log(pairs)
                    pairs.push([i + 1, j + 1]);
                    console.log(pairs)
                } else if (total == maxMiles) {
                    pairs.push([i + 1, j + 1]);
                    console.log(pairs)
                }
            }

        }
    }

    console.log("## OUTPUT:", pairs);
}

let maxTravelDist = 7000,
    forwardRouteLit = [[1, 2000]],
    returnRouteList = [[1, 2000], [2, 4000], [3, 6000]];
optimalUtilization(maxTravelDist, forwardRouteLit, returnRouteList);
// let maxTravelDist = 10000,
//     forwardRouteLit = [[1,3000],[2,5000],[3,7000],[4,10000]],
//     returnRouteList = [[1,2000],[2,3000],[3,4000],[4,5000]];
// optimalUtilization(maxTravelDist, forwardRouteLit, returnRouteList);