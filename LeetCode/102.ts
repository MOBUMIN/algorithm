import { TreeNode } from "../common";

function levelOrder(root: TreeNode | null): number[][] {
    const answer:number[][] = [];

    const traverse = (node: TreeNode | null, level: number) => {
        if(!node) return;
        if(!answer[level]) answer.push([node.val]);
        else answer[level].push(node.val);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }

    traverse(root, 0);

    return answer;
};
