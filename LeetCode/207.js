/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
 var canFinish = function(numCourses, prerequisites) {
    const nodeNum = prerequisites.length;

    const visited = new Array(nodeNum).fill(false);
    const cycle = new Array(nodeNum).fill(false);

    for(let i=0; i<nodeNum; i++) {
        if(!dfs(visited, cycle, prerequisites, i)) return false;
        visited[i] = true;
    }
    return true;
};

const dfs = (visited, cycle, prerequisites, index) => {
    if(cycle[index]) return false;
    if(visited[index]) return true;
    cycle[index] = true;

    const [a, b] = prerequisites[index];
    const preCourses = getPreCouses(b, prerequisites);
     //console.log(index, [a, b],'방문해볼게요~', preCourses);
    for(let i=0; i<preCourses.length; i++) {
        const nodeIndex = prerequisites.indexOf(preCourses[i])
        if(!dfs(visited, cycle, prerequisites, nodeIndex)) return false;
        visited[nodeIndex] = true;
    }
    cycle[index] = false;
    return true;
}

const getPreCouses = (index, array) => array?.filter(item => item[0]===index);
