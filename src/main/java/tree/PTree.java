package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/14
 */
public class PTree implements Tree {

    private  static final  int maxSize=100;

    private PTNode[] nodes;/*结点数组*/
    private int r;   /*根结点的位置*/
    private int n;  /*结点数量*/




    public PTree() {
        this.nodes = new PTNode[maxSize];
        this.r = -1;     /*遇到根节点的位置为-1*/
        this.n = 0;
    }

    @Override
    public Tree initTree() {
        return new PTree();
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


    public PTNode[] getNodes() {
        return nodes;
    }

    public void setNodes(PTNode[] nodes) {
        this.nodes = nodes;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
