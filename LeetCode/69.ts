function mySqrt(x: number): number {
    if (x === 1 || x === 0) return x;
    let n = x;
    let y = (x + 1) / 2;
    while(y < x) {
        x = y;
        y = Math.floor(( x + n/x ) / 2);
    }

    return x;
};
