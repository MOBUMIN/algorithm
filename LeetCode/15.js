function threeSum(nums) {
    nums.sort((a, b) => a-b);
    const positiveIndex = nums.findIndex(val => val > 0);
    const answer = new Set();
    const answerArr = [];

    if(positiveIndex === -1) {
        if(nums.filter((num) => num===0).length > 2) return [[0, 0, 0]];
        return [];
    }

    for(let i=0; i<positiveIndex; i++) {
        let left = i+1;
        let right = nums.length-1;
        
        while(left < right) {
            const threeSum = nums[left] + nums[i] + nums[right];
            if(threeSum > 0) right--;
            else if(threeSum < 0) left++;
            else {
                answer.add(`${nums[i]},${nums[left]},${nums[right]}`);
                left++;
                right--;
            }
        }
    }

    for(let str of answer) answerArr.push(str.split(','));

    return answerArr
};
