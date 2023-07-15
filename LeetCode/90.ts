function subsetsWithDup(nums: number[]): number[][] {
    nums.sort(function(a, b)  {
        return a - b;
    });
    
    const ans = [''];
    const realAns = [[]];

    for(let i=0; i<nums.length; i++) {
       
       const currentAns = [...ans];
       for(const string of currentAns) {
           let temp = '';
           if(string === '') temp = `${nums[i]}`;
           else temp = `${string}, ${nums[i]}`;

           if(!ans.includes(temp)) {
               ans.push(temp);
               realAns.push(temp.split(',').map(data => Number(data)))
           }
       }
    }

    return realAns;
}