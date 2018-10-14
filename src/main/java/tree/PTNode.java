package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/14
 */
public class PTNode {
    private Object data;
    private int parent;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
