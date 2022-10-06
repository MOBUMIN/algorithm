/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

 function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
    return dfs(p, q);
};

function dfs (p: TreeNode | null, q: TreeNode | null): boolean  {
    if(p?.val !== q?.val) return false;
    if(!p && !q) return true;

    let result;
    result = dfs(p.left, q.left);
    if(!result) return result;
    result = dfs(p.right, q.right);
    return result;
}
