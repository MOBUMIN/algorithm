/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if(nums.length === 1 || nums[0] === 0 ) return 0;
    let answer = 1;
    let nextIdx = 0;
    let nextJumpValue = -1;
    const finishIdx = nums.length-1;
    for(let currentIdx=0; currentIdx<nums.length; currentIdx = nextIdx) {
        console.log(currentIdx);

        if(currentIdx + nums[currentIdx] >= finishIdx) break;

        for(let start = currentIdx+1; start <= currentIdx + nums[currentIdx]; start++) {
            if(nextJumpValue <= start + nums[start]) {
                nextIdx = start;
                nextJumpValue = start + nums[start];
            }
        }
        nextJumpValue = 0;
        answer++;
    }

    return answer;
};
