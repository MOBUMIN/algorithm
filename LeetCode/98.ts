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
// 중위 순회로 오름차순인지 확인
function isValidBST(root: TreeNode | null): boolean {
    let prev = null;

    const validate = (node) => {
         if (node === null) {
            return true;
        }
        
        if (!validate(node.left)) {
            return false;
        }
        
        if (prev !== null && node.val <= prev) {
            return false;
        }
        prev = node.val;
        
        return validate(node.right);
    }

    return validate(root);
};
