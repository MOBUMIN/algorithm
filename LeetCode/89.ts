function grayCode(n: number): number[] {
    const answer = [0];
  
    for(let i=0; i<2**n - 1; i++) {
      for(let j=0; j<n; j++) {
        const temp = answer[i] ^ 2**j
        if(!answer.includes(temp)) {
          answer.push(temp);
          break;
        }
      }
    }
  
    return answer;
  };
  