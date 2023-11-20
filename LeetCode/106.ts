function buildTree(inorder: number[], postorder: number[]): TreeNode | null {
    const make = (postorder: number[], inorder: number[]):TreeNode => {
        if (!postorder.length || !inorder.length) {
            return null;
        }
        const rootNode = new TreeNode(postorder.pop());
        const inorderRootIndex = inorder.indexOf(rootNode.val);
        rootNode.right = make(postorder, inorder.slice(inorderRootIndex + 1));
        rootNode.left = make(postorder, inorder.slice(0, inorderRootIndex));

        return rootNode;
    }

    return make(postorder, inorder)  
};
