package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/23
 */
public class HuffmanNode implements Node {
    private Object data;
    private int weight;
    private HuffmanNode leftChild;
    private HuffmanNode rightChild;

    public HuffmanNode() {
    }

    public HuffmanNode(Object data, int weight, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.data = data;
        this.weight = weight;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public HuffmanNode(Object data, int weight) {
        this(data, weight, null, null);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }


}
