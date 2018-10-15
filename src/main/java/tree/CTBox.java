package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 孩子表示法的表头结点
 * @date:2018/10/15
 */
public class CTBox implements Node{
    private Object data;
    private CTChildNode firstChild;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public CTChildNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(CTChildNode firstChild) {
        this.firstChild = firstChild;
    }
}
