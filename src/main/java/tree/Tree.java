package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/14
 */
public interface Tree {
    Tree initTree();

    void destroyTree();

    Tree createTree(String definition);

    void clearTree();

    boolean isEmpty();

    int treeDepth();

    Node root();

    Object value(Node cur_e);

    void assign(Node cur_e, Object value);

    Node parent(Node cur_e);

    Node leftChild(Node cur_e);

    Node rightSibling(Node cur_e);

    void InsertChild(Node p, int i, Node c);

    void deleteChild(Node p, int i);
}
