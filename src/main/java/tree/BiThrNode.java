package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉线索树结点
 * @date:2018/10/20
 */
public class BiThrNode {
    private Object data;
    private BiThrNode lChild;
    private BiThrNode rChild;
    private NodeTag lTag;
    private NodeTag rTag;



    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BiThrNode getlChild() {
        return lChild;
    }

    public void setlChild(BiThrNode lChild) {
        this.lChild = lChild;
    }

    public BiThrNode getrChild() {
        return rChild;
    }

    public void setrChild(BiThrNode rChild) {
        this.rChild = rChild;
    }

    public NodeTag getlTag() {
        return lTag;
    }

    public void setlTag(NodeTag lTag) {
        this.lTag = lTag;
    }

    public NodeTag getrTag() {
        return rTag;
    }

    public void setrTag(NodeTag rTag) {
        this.rTag = rTag;
    }
}
