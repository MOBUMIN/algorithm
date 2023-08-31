function twoSum(nums: number[], target: number): number[] {
    let temp;
    let ans;
    for(let i=0; i<nums.length; i++) {
        if(temp === target) break;
        temp = nums[i];
        ans = [i];
        for(let j=i+1; j<nums.length; j++) {
            if(temp + nums[j] === target){
                temp += nums[j];
                ans.push(j);
                break;
            } 
        }
    }

    return ans;
};
