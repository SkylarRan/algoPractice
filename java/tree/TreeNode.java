package tree;

public class TreeNode<E> {
    private E data;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    public TreeNode(E data) {
        this.data = data;
    }

    public TreeNode(E data, TreeNode<E> leftChild, TreeNode<E> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<E> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<E> rightChild) {
        this.rightChild = rightChild;
    }
}
