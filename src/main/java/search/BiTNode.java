package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/30
 */
public class BiTNode {

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
