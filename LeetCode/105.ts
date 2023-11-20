function buildTree(preorder: number[], inorder: number[]): TreeNode | null {

    const make = (preorder: number[], inorder: number[]):TreeNode => {
        if (!preorder.length || !inorder.length) {
            return null;
        }
        const rootNode = new TreeNode(preorder.shift());
        const inorderRootIndex = inorder.indexOf(rootNode.val);
        rootNode.left = make(preorder, inorder.slice(0, inorderRootIndex));
        rootNode.right = make(preorder, inorder.slice(inorderRootIndex + 1));

        return rootNode;
    }

    return make(preorder, inorder)
};
