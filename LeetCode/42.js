/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
    let ans = 0;
    let len = height.length;
    if(len === 0) return 0;
    const leftMaxArr = new Array(len).fill(0);
    const rightMaxArr = new Array(len).fill(0);
    leftMaxArr[0] = height[0];
    rightMaxArr[len-1] = height[len-1];

    for(let i=1; i<len; i++) {
        leftMaxArr[i] = Math.max(height[i], leftMaxArr[i-1]);
    }
    for(let i=len -2; i>=0; i--) {
        rightMaxArr[i] = Math.max(height[i], rightMaxArr[i+1]);
    }

    for(let i=1; i<len-1; i++) {
        ans += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
    }

    return ans;
};
