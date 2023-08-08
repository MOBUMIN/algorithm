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

function generateTrees(n: number): Array<TreeNode | null> {

    // 1 [1]
    // 2 [1-2, 2-1]
    // 3 [1-2-3, 1-3-2, 2-1-3, 3-2-1, 3-1-2]
    // 4 [1-2-3-4, 1-3-2-4, 1-2-4-3, ...]

    const makeTree = (start: number, end:number):Array<TreeNode> => {
        const trees:Array<TreeNode> = new Array();

        if(start > end) {
            trees.push(null);
            return trees;
        }
        if(start === end) {
            trees.push(new TreeNode(start));
            return trees;
        }

        for(let i = start; i<=end; i++) {
            const leftTrees = makeTree(start, i-1);
            const rightTrees = makeTree(i+1, end);
            for(let l = 0; l < leftTrees.length; l++) {
                for(let r = 0; r < rightTrees.length; r++) {
                    const tree = new TreeNode(i);
                    tree.left = leftTrees[l] || null;
                    tree.right = rightTrees[r] || null;

                    trees.push(tree);
                }
            }
        }

        return trees;
    }


    return makeTree(1, n);
};
