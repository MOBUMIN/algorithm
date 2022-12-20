/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
 var removeElement = function(nums, val) {
    let answer = 0;
    for(let i=0; i<nums.length; i++) {
        if(nums[i]===null) continue;
        if(nums[i] === val) {
            for(let j=i+1; j<nums.length; j++) {
                if(nums[j] !== val) {
                    nums[answer++] = nums[j];
                    nums[j] = null;
                    break;
                }
                else {
                    nums[j] = null;
                }
            }
        }
        else nums[answer++] = nums[i];
    }

    return answer;
};
