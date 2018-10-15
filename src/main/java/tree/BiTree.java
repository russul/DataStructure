package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉链表
 * @date:2018/10/15
 */
public class BiTree implements Tree{

    private BiTNode head; //头结点

    public BiTree(){
        head = new BiTNode();
    }

    @Override
    public Tree initTree() {
        return new BiTree();
    }

    @Override
    public void destroyTree() {

    }

    @Override
    public Tree createTree(String definition) {
        return null;
    }

    @Override
    public void clearTree() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int treeDepth() {
        return 0;
    }

    @Override
    public Node root() {
        return null;
    }

    @Override
    public Object value(Node cur_e) {
        return null;
    }

    @Override
    public void assign(Node cur_e, Object value) {

    }

    @Override
    public Node parent(Node cur_e) {
        return null;
    }

    @Override
    public Node leftChild(Node cur_e) {
        return null;
    }

    @Override
    public Node rightSibling(Node cur_e) {
        return null;
    }

    @Override
    public void InsertChild(Node p, int i, Node c) {

    }

    @Override
    public void deleteChild(Node p, int i) {

    }
}
