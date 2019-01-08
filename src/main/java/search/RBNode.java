package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2019/1/7 0007
 */
public class RBNode {
    public int key;
    //true：红；false：黑
    public boolean color;
    public RBNode left;
    public RBNode right;
    public RBNode parent;

    public RBNode(int key) {
        this.key = key;
    }

    public RBNode(int key, boolean color) {
        this.key = key;
        this.color = color;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "key=" + key +
                ", color=" + color +
                '}';
    }
}
