function largestRectangleArea(heights: number[]): number {
	const stack = [];
	let ans = 0;
	
	for (let i = 0; i <= heights.length; i++) {
	  while (stack.length > 0 && (i === heights.length || heights[i] < heights[stack[stack.length - 1]])) {
		const height = heights[stack.pop()];
		const width = stack.length === 0 ? i : i - stack[stack.length - 1] - 1;
		ans = Math.max(ans, height * width);
	  }
	  
	  stack.push(i);
	}
	
	return ans;
  };