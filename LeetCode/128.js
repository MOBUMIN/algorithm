var longestConsecutive = function(nums) {
    if(nums.length === 0) return 0;

    let 정답 = 1;
    let 비교군 = 1;
    nums.sort((a, b) => a-b);

    for(let i=1; i<nums.length; i++) {
        if(nums[i] === nums[i-1] + 1)
            비교군 = 비교군 + 1
        else if(nums[i] === nums[i-1]) continue;
        else {
            정답 = 비교군 > 정답? 비교군 : 정답;
            비교군 = 1;
        }
    }
    정답 = 비교군 > 정답? 비교군 : 정답;
    return 정답;
};
