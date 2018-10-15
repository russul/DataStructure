package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 孩子表示法的孩子结点
 * @date:2018/10/15
 */
public class CTChildNode {
    private int child;
    private CTChildNode next;

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public CTChildNode getNext() {
        return next;
    }

    public void setNext(CTChildNode next) {
        this.next = next;
    }
}
