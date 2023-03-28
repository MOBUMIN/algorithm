function getPermutation(n: number, k: number): string {
    const permutations = [];

    const permute = (str) => {
        if(permutations.length >= k) return;
        if(str.length === n){
            permutations.push(str);
        }
        else {
            for(let i=1; i<=n; i++) {
                if(!str.includes(i)) {
                    permute(str.concat(i));
                }
            }
        }
    }

    permute("");

    return permutations[k-1];
};
