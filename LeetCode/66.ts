function plusOne(digits: number[]): number[] {
    const len = digits.length;
    
    for(let i=len-1; i>=0; i--) {
        digits[i]++;
        if(digits[i] === 10) {
            digits[i] = 0;

            if(i===0) digits.unshift(1);
        }
        else break;
    }

    return digits;
};
