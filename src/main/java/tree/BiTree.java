package tree;

import java.util.Map;
import java.util.Scanner;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉链表
 * @date:2018/10/15
 */
public class BiTree implements Tree {

    private BiTNode root; /*根结点*/
    private String[] treeData;
    private int index;

    /*初始化一个空链表*/
    public BiTree() {
        root = null;
    }

    /*根据给定的字符串数组按前序输入为各结点的值生成一棵二叉树*/
    public BiTree(String[] treeData) {
        this.treeData = treeData;
        /*从根结点开始，因为前序遍历序列的根结点就是第一个*/
        this.index = 0;
        root = createBiTreePre();
    }

    /*根据给定的字符串数据（格式用，号分割）按后序输入为各结点的值来生成二叉树*/
    public BiTree(String Data) {

        this.treeData = Data.split(",");
        /*从根结点开始，因为后序遍历序列的根结点是最后一个*/
        index = treeData.length - 1;
        root = createBiTreePost();
    }

    public BiTree(String Data,String type){
        /*根据给定的字符串数组按前序输入为各结点的值生成一棵二叉树*/
        if ("pre".equalsIgnoreCase(type)){
            this.treeData = Data.split(",");
            /*从根结点开始，因为前序遍历序列的根结点就是第一个*/
            this.index = 0;
            root = createBiTreePre();
        }
        /*根据给定的字符串数据（格式用，号分割）按后序输入为各结点的值来生成二叉树*/
        if ("post".equalsIgnoreCase(type)){
            this.treeData = Data.split(",");
            /*从根结点开始，因为后序遍历序列的根结点是最后一个*/
            index = treeData.length - 1;
            root = createBiTreePost();
        }
        /*根据给定的字符串数据（格式用，号分割）按中序输入为各结点的值来生成二叉树*/
        if ("in".equalsIgnoreCase(type)){
            this.treeData = Data.split(",");
            /*由于中序遍历序列不能唯一确定二叉树结构，在创建二叉树时，要指定根结点，
            这里为了二叉树的结构和前序和后序保持一致，选择A作为根结点（实际上ABCD四个结点都能作为根结点）*/
            index = 5;/*中序遍历序列为#B#D#A#C#*/
        }

    }


    @Override
    public Tree initTree() {
        return new BiTree();
    }

    @Override
    public void destroyTree() {

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 14:47
     * @param [definition]
     * @return tree.Tree
     * @description 根据给定的树的定义生成树(后序输入创建树)
     */
    @Override
    public Tree createTree(String definition) {



        return new BiTree(definition);
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
        return root;
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

    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 9:34
     * @param []
     * @return void
     * @description 二叉树的前序遍历
     */
    public void preOrderTraverse(BiTNode node) {
        //参数为啥给一个结点，因为这个结点（头结点或者根结点）是唯一的，可以代表这棵树
        if (node == null) {
            return;
        }
        System.out.println(node.getData());/*显示结点数据*/
        preOrderTraverse(node.getLeftChild());/*先前序遍历结点的左孩子*/
        preOrderTraverse(node.getRightChild());/*再前序遍历结点的右孩子*/

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 9:34
     * @param []
     * @return void
     * @description 二叉树的前序遍历
     */
    public void preOrderTraverse() {
        //参数也可以不给，因为从当前对象可以获取头结点或者根结点
        if (root() == null) {
            return;
        }
        System.out.println(((BiTNode) root()).getData());/*显示结点数据*/
        preOrderTraverse(((BiTNode) root()).getLeftChild());/*先前序遍历结点的左孩子*/
        preOrderTraverse(((BiTNode) root()).getRightChild());/*再前序遍历结点的右孩子*/

    }



    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 10:22
     * @param
     * @return
     * @description 二叉树的中序遍历
     */

    public void inOrderTraverse(BiTNode node) {
        //参数为啥给一个结点，因为这个结点（根结点）是唯一的，可以代表这棵树
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeftChild());/*中序遍历左子树（结点的左孩子）*/
        System.out.println(node.getData());/*显示结点数据，可以更改为对结点的其他操作*/
        inOrderTraverse(node.getRightChild());/*中序遍历右子树（结点的右孩子）*/
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 10:22
     * @param
     * @return
     * @description 二叉树的中序遍历
     */

    public void inOrderTraverse() {
        //参数为啥给一个结点，因为这个结点（根结点）是唯一的，可以代表这棵树
        if (root == null) {
            return;
        }
        inOrderTraverse(root.getLeftChild());/*中序遍历左子树（结点的左孩子）*/
        System.out.println(root.getData());/*显示结点数据，可以更改为对结点的其他操作*/
        inOrderTraverse(root.getRightChild());/*中序遍历右子树（结点的右孩子）*/
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 10:25
     * @param [node]
     * @return void
     * @description 二叉树的后序遍历
     */
    public void postOrderTraverse(BiTNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeftChild());/*后序遍历左子树（结点的左孩子）*/
        postOrderTraverse(node.getRightChild());/*后序遍历右子树（结点的右孩子）*/
        System.out.println(node.getData());/*显示结点数据，可以更改为对结点的其他操作*/
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 14:47
     * @param []
     * @return tree.BiTNode
     * @description 通过扩展二叉树的前序遍历序列创建二叉树（按照前序输入二叉树的各结点值）
     */
    public BiTNode createBiTreePre() {
        String data = treeData[index];
        System.out.println(treeData[index]);
        index++;
        BiTNode node;
        if (data.equalsIgnoreCase("#")) {  /*如果在前序输入中是#号代表这个子树创建完毕，返回*/
            node = null;
            return node;
        } else {
            node = new BiTNode();
            node.setData(data);
            node.setLeftChild(createBiTreePre());  /*和前序遍历一样，进行递归调用，这不过这里对结点的操作不同了*/
            node.setRightChild(createBiTreePre());
            return node;                           /*最后创建结束返回根结点(因为前序输入第一个结点必然是根结点)*/
        }

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 15:03
     * @param []
     * @return tree.BiTNode
     * @description  通过扩展二叉树的中序遍历序列创建二叉树（按照中序输入二叉树的各结点值），
     * 由于中序遍历序列不能唯一确定二叉树结构，在创建二叉树时，要指定根结点
     */
    private BiTNode createBiTreeIn() {
        /*未实现*/
        String data = treeData[index];
        System.out.println(treeData[index]);

        if (index>0){

        }

        index++;
        BiTNode node = new BiTNode();
        if (data.equalsIgnoreCase("#")) {  /*如果是#号代表这个子树创建完毕，返回*/
            node = null;
            return node;
        } else {


            node.setLeftChild(createBiTreeIn());  /*和中序遍历一样，进行递归调用，这不过这里对结点的操作不同了*/
            node.setData(data);
            node.setRightChild(createBiTreeIn());
            return node;                           /*最后创建结束返回根结点*/
        }


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/16 15:03
     * @param []
     * @return tree.BiTNode
     * @description  后序创建二叉树（按照前序输入二叉树的各结点值）
     */
    private BiTNode createBiTreePost() {

        //后续遍历的根节点一定是在最后面，所以让index从数组的最后一个往前走，这样可以保证最后返回的一定时根结点
        String data = treeData[index];
        System.out.println(treeData[index]);
        index--;
        BiTNode node = new BiTNode();
        if (data.equalsIgnoreCase("#")) {  /*如果是#号代表这个子树创建完毕，返回*/
            node = null;
            return node;
        } else {

            //由于遍历时是左右根的顺序，比如一个扩展二叉树的后序遍历序列是“###DB##CA”,
            // 由于逆序操作，发现紧挨着A的C是其右孩子，所以在生成时顺序为右左根
            node.setRightChild(createBiTreePost());
            node.setLeftChild(createBiTreePost());  /*和中序遍历一样，进行递归调用，这不过这里对结点的操作不同了*/
            node.setData(data);
            return node;                           /*最后创建结束返回根结点*/
        }


    }


}
