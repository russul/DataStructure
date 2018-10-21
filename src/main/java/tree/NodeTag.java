package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/20
 */
public enum NodeTag {
    /*Link代表连接是孩子，Thread代表连接的是线索（前驱和后继）*/
    Link(0), Thread(1);
    private int value;

    NodeTag() {

    }

    NodeTag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
