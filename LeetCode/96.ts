// n==1, 1
// n==2, 1-2, 2-1, 2 -> 10 01 = 1 + 1
// n==3, ..., 5 ->  20 11 02 = 1 * 2 + 2 * 1 + 1
// n==4, ..., 14 -> 30 12 21 03 = 1 * 5 + 5 * 1 + 2 * 2 = 14
// 40 31 22 13 04 = 14 + 5 + 4 + 5 + 14 = 14*3 = 42

function numTrees(n: number): number {
    const dp = [1, 1, 2, 5, 14];
    const makeTree = (num:number):number => {
       if(dp[num]) return dp[num];
       let temp = 0;
       for(let i = 0; i < num; i++) {
            temp += (makeTree(i) * makeTree(num - i - 1));
       }
       dp[num] = temp;
       return dp[num];
    }

    makeTree(n);
    return dp[n];
};
