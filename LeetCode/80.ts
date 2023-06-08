function removeDuplicates(nums: number[]): number {
    let realIndex = 1;
    let curIndex = 1;
    let temp = nums[0];
    let sameTime = false;

    while(curIndex < nums.length) {
        if(sameTime && nums[curIndex] === temp) {
            while(nums[curIndex] === temp && curIndex < nums.length) {
                curIndex++;
            }
            if(curIndex < nums.length) {
                sameTime=false;
                temp = nums[curIndex];
                nums[realIndex++] = nums[curIndex++];
            }
        }
        else if(nums[curIndex] === temp) {
            nums[realIndex++] = nums[curIndex++];
            sameTime = true;
        } else {
            sameTime = false;
            temp = nums[curIndex];
            nums[realIndex++] = nums[curIndex++];
        }
    }

    return realIndex;
};
