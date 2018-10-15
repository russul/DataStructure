package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉链表结点
 * @date:2018/10/15
 */
public class BiTNode implements Node {
    private Object data;
    private BiTNode leftChild;
    private BiTNode rightChild;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BiTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BiTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BiTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BiTNode rightChild) {
        this.rightChild = rightChild;
    }
}
