package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/15
 */
public class CTree implements Tree{
    private  static final  int maxSize=100;

    private CTBox[] nodes;/*结点数组*/
    private int r;   /*根结点的位置*/
    private int n;  /*结点数量*/




    public CTree() {
        this.nodes = new CTBox[maxSize];
        this.r = -1;     /*遇到根节点的位置为-1*/
        this.n = 0;
    }

    @Override
    public Tree initTree() {
        return new CTree();
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


    public CTBox[] getNodes() {
        return nodes;
    }

    public void setNodes(CTBox[] nodes) {
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
