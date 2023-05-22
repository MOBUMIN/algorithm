/**
 Do not return anything, modify nums in-place instead.
 */
 function sortColors(nums: number[]): void {
    const swap = (a, b) => {
        const temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    for(let i=0; i<nums.length-1; i++) {
        for(let j=0; j<nums.length-1; j++) {
            if(nums[j] > nums[j+1]) {
                swap(j,j+1);
            }
        }
    }
};
