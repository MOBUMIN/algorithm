/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
 var nextPermutation = function(nums) {
    let initialVal = nums.length-1;
    let 역전 = initialVal;
    let 증가 = initialVal;
    for(let i=initialVal; i>0; i--) {
       if(nums[i] < nums[i-1]) {
           if(역전 === initialVal) 역전 = i-1;
           if(증가 !== initialVal) break;
       }
       else if(nums[i] > nums[i-1]) {
           if(증가 === initialVal)증가 = i-1;
           if(역전 !== initialVal) break;
       }
    }
    if(증가 === initialVal) nums.sort((a, b) => a-b);
    else if (역전 === initialVal) swap(nums, initialVal, initialVal-1);
    else if (역전 < 증가) swap(nums, 증가, 증가+1);
    else {
        let b;
        for(let i=initialVal; i>=0; i--)
            if(nums[i] > nums[증가]){
                b=i;
                break;
            }
        swap(nums, 증가, b);

        let j= initialVal;
        for(let i=증가+1; i<=j; i++) {
            swap(nums, i, j--);
        }
    }
};

const swap = (nums, a, b) => {
    const temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
}
