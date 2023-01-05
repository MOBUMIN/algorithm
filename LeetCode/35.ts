function searchInsert(nums: number[], target: number): number {
    let start = 0;
    let end = nums.length-1;
    let mid;

    if(target <= nums[0]) return 0;
    while(start <= end) {
        mid = Math.floor((start+end)/2)
        if(target === nums[mid]) {
            break;
        }
        else {
            if(target < nums[mid]) end = mid-1;
            else start = mid+1;
            if(start > end) {
                mid = start;
            }
        }
    }
    return mid;
};