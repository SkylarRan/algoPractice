package tree;

import java.util.List;

/**
 * 链式存储的二叉树，会有左右子节点，适用于非完全二叉树
 */
public class LinkBinaryTree<E> {
    private TreeNode<E> root;

    private List<TreeNode> nodeList = null;

    public LinkBinaryTree(TreeNode<E> root) {
        this.root = root;
    }


}
