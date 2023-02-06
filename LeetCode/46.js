/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    const ans = [];

    backtraking(nums, [], ans);
    
    return ans;
};

const backtraking = (nums, temp, ans) => {
    if(nums.length === temp.length) {
        ans.push(temp);
        return;
    }
    for(let i=0; i<nums.length; i++) {
        if(!temp.includes(nums[i]))
            backtraking(nums, [...temp, nums[i]], ans);
    }
}
