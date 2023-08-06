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

// LNR
function inorderTraversal(root: TreeNode | null): number[] {
    const ans:number[] = [];
    const find = (node:TreeNode) => {
        if(node.left) find(node.left);
        ans.push(node.val);
        if(node.right) find(node.right);
    }
    if(root) find(root);
    return ans;
};
