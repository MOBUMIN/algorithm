/**
 * @param {number[]} nums
 * @return {number}
 */
 var removeDuplicates = function(nums) {
    const length = nums.length;
    for(let i=0; i<length; i++) {
        if(nums[i] === undefined) break;
        let lastIndex = nums.lastIndexOf(nums[i])
        if(i !== lastIndex) {
            nums.splice(i+1, lastIndex-i)
        }
    }
};
