package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/31
 */
public class AVLTNode {
    private Object data;
    private int   balanceFactor;
    private AVLTNode leftChild;
    private AVLTNode rightChild;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public AVLTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLTNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLTNode rightChild) {
        this.rightChild = rightChild;
    }
}
