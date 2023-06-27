function largestRectangleArea(heights: number[]): number {
	const indexList = [];
	let ans = 0;
	
	for (let i = 0; i <= heights.length; i++) {
	  while (indexList.length > 0 && (i === heights.length || heights[i] < heights[indexList[indexList.length - 1]])) {
		const height = heights[indexList.pop()];
		const width = indexList.length === 0 ? i : i - indexList[indexList.length - 1] - 1;
		ans = Math.max(ans, height * width);
	  }
	  
	  indexList.push(i);
	}
	
	return ans;
  };
  