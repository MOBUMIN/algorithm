function searchRange(nums: number[], target: number): number[] {
    let start = 0;
    let end = nums.length-1;
    let mid;
    let a= -1, b = -1;

    while(start <= end) {
        mid = Math.floor((start+end)/2)
        if(target === nums[mid]) {
            a = mid;
            b = mid;
            while(nums[a--] === target){}
            while(nums[b++] === target){}
            a+=2; b-=2;
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
    return [a,b];
};