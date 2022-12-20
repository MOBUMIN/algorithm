/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
 var divide = function(dividend, divisor) {
    if(dividend === -2147483648 && divisor === -1) {
    	return 2147483647;
    }
    if(divisor === 1) return dividend;

    let ans = 0;
    let absA = Math.abs(dividend);
    const absB = Math.abs(divisor);
    const shouldMinus = !( (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
    while(absA >= absB) {
        absA -= absB
        ans++;
    }

    return shouldMinus ? ans * -1 : ans;
}
