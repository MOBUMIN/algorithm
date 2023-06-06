function subsets(nums: number[]): number[][] {
    const len = nums.length;
    const answer = [[]];
    const make = (arr, index, finish) => {
        if(arr.length === finish) {
            answer.push(arr);
        } else {
            for(let j=index; j<len; j++) {
                make([...arr, nums[j]], j+1, finish);
            }
        }
    }

    for(let i=1; i<=len; i++) {
        make([], 0, i);
    }

    return answer;
};
