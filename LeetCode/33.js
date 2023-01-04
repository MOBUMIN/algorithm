/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let start = 0;
    let end = nums.length-1;
    let mid;

    while(start <= end) {
        mid = Math.floor((start+end)/2)
        if(target === nums[mid]) return mid;
        else {
            if(isInFront(nums, target, start, mid)) end = mid-1;
            else start = mid+1;
        }
    }

    return -1;
};

function isInFront(nums, target, start, mid) {
    if (nums[start] <= nums[mid]) {
        return target < nums[mid] && target >= nums[start];
    } else {
        return target < nums[mid] || target >= nums[start];
    }
}