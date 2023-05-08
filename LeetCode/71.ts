function simplifyPath(path: string): string {
    const pathArr = path.split('/');
    for(let i=0; i<pathArr.length; i++) {
        console.log(i, pathArr);
        if(pathArr[i]) {
            if(pathArr[i] === '..') {
                if(i-1 >= 0) {
                    pathArr.splice(i-1, 2);
                    i=i-2;
                }
                else {
                    pathArr[i] = ''
                    i--;
                }
            }
            else if(pathArr[i] === '.') {
                pathArr.splice(i, 1)
                i--;
            }
        }
        else { // slash인 경우
        console.log('slash!');
            if(i === pathArr.length-1) pathArr.splice(i, 1);
            else if(i-1 >=0 && !pathArr[i-1]) {
                console.log('splice')
                pathArr.splice(i, 1);
                i--;
            }
            else {
                pathArr.splice(i, 1)
                i--;
            }
        }
    }

    return '/' + pathArr.join('/')
};
