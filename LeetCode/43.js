/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    if(num1 === "0" || num2 ==="0") return "0";
    const result = new Array(num1.length + num2.length).fill(0);
    let endIdx = result.length-1;
    for(let i=0; i<num2.length; i++) {

        for(let j=0; j<num1.length; j++) {
            result[endIdx-i-j] += num2[num2.length-1-i] * num1[num1.length-1-j];
        }
    }

    let overflow = 0;
    for(endIdx; endIdx >= 0; endIdx--) {
        if(overflow >= 1) result[endIdx] += overflow;
        overflow = Math.floor(result[endIdx] / 10);
        result[endIdx] %= 10;
    }
    // console.log(result);

    let startIdx;
    for(startIdx=0; startIdx<result.length; startIdx++) if(result[startIdx] !== 0) break;
    return result.join('').slice(startIdx);
};