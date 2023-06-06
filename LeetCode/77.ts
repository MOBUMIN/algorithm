function combine(n: number, k: number): number[][] {
    const answer = [];
    const make = (arr: number[], index: number) => {
        if(arr.length === k) {
            answer.push(arr);
        }
        else {
            for(let j=index; j<=n; j++) {
                make([...arr, j], j+1);
            }
        }
    }

    make([], 1);

    return answer;
};