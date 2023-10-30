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

function isSymmetric(root: TreeNode | null): boolean {
    const mirrorTemp = [];
    let left = root.left;
    let right = root.right;

    const checkLeftTree = (root) => {
        if(root===null) {
            mirrorTemp.push(null);
            return;
        }
        checkLeftTree(root.left);
        checkLeftTree(root.right);
        mirrorTemp.push(root.val);
    }

    const checkRightTree = (root) => {
        if(root===null) {
            if(mirrorTemp[0] !== null) throw new Error('not symetric');
            mirrorTemp.shift();
            return;
        }
        checkRightTree(root.right);
        checkRightTree(root.left);
        if(mirrorTemp[0] !== root.val) throw new Error('not symetric');
        mirrorTemp.shift();
    }

    checkLeftTree(left);
    try{
        checkRightTree(right);
    } catch { return false;}

    if(mirrorTemp.length > 0) return false;
    return true;
};
