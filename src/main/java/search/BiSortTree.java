package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉排序树
 * @date:2018/10/30
 */
public class BiSortTree {

    private BiTNode root;

    private BiTNode current;/*充当二叉排序树查找的当前结点的全局变量*/

    public BiSortTree() {
        this.root = null;
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 17:46
     * @param [root, key, parent]
     * @return java.lang.String
     * @description 二叉排序树的查找操作
     */
    public String searchBST(BiTNode root, int key, BiTNode parent) {
        if (root == null) {
            this.current = parent;
            return "FALSE";
        } else if (key == (int) ((Integer) root.getData())) {
            this.current = root;
            return "TRUE";
        } else if (key < (Integer) root.getData()) {
            return searchBST(root.getLeftChild(), key, root);
        } else {
            return searchBST(root.getRightChild(), key, root);
        }
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 17:46
     * @param [root, key, parent]
     * @return java.lang.String
     * @description 二叉排序树的查找操作
     */

    /*参数：
    root:树的根结点；
    key:关键字；
    parent：始终指向root（root在递归中会不断变化）的双亲，初始值给null；
    current（返回值）:查找成功指向该结点，失败指向查找路径上访问的最后一个结点，它在后续的插入操作中有很大的作用*/
    public BiTNode searchBST(BiTNode root, int key, BiTNode parent, BiTNode current) {
        if (root == null) {                 /*递归出口地址1，查找失败*/
            /*将parent赋值给current，因为parent一直赋值为root（上一次不为空的结点），
            这样当查询失败时，current就指向了查询路径上的最后一个结点*/
            current = parent;
            System.out.println("FALSE");
            return current;
        } else if (key == (int) ((Integer) root.getData())) {
            /*查询成功，将current指向该root（结点）*/
            current = root;
            System.out.println("TRUE");
            return current;
        } else if (key < (Integer) root.getData()) {
            /*小于就递归左子树*/
            return searchBST(root.getLeftChild(), key, root, current);
        } else {
            /*大于就递归右子树*/
            return searchBST(root.getRightChild(), key, root, current);
        }
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 17:47
     * @param
     * @return
     * @description 二叉排序树的插入操作
     */

    public BiTNode insertBST(BiTNode root, int key) {

        BiTNode s;
        if (searchBST(root, key, null).equals("FALSE")) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            if (Search.current == null) {
                root = s;
            } else if (key < (Integer) Search.current.getData()) {
                Search.current.setLeftChild(s);
            } else {
                Search.current.setRightChild(s);
            }

            System.out.println("true");
        } else {
            System.out.println("false");
        }

        return root;
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 17:47
     * @param
     * @return
     * @description 二叉排序树的插入操作
     */

    public BiTNode insertBST2(BiTNode root, int key) {

        BiTNode s;
        BiTNode p = new BiTNode();
        /*搜索树中有没有该关键字，并返回当前的位置的一个指针*/
        BiTNode current = searchBST(root, key, null, p);

        /*current=null表示树是一棵空树，执行插入操作*/
        if (current == null) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            root = s;
            System.out.println("true");
            return root;
        }
        /*current的数据和关键字不同说明树中不存在，执行插入*/
        if (key != (Integer) current.getData()) {
            s = new BiTNode();
            s.setData(key);
            s.setLeftChild(null);
            s.setRightChild(null);

            /*小于，插入左侧，否则插入右侧；这里由于有current的存在，就确定了插入的位置*/
            if (key < (Integer) current.getData()) {
                current.setLeftChild(s);
            } else {
                current.setRightChild(s);
            }

            System.out.println("true");
            return root;
        } else {

            /*key和current的数据相同，表示树中已经存在，不进行插入操作*/
            System.out.println("false");
            return root;
        }


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 17:48
     * @param [root, key]
     * @return search.BiTNode
     * @description 二叉树的删除操作
     */

    /*root始终指向树的根结点*/
    public BiTNode deleteBST(BiTNode root, int key) {
        if (root == null) {          /*递归的出口条件1*/

            return root;
        } else {

            if (key == (Integer) root.getData()) {      /*递归的出口条件2，相等就执行删除操作*/
                root = delete(root);
                return root;
            } else if (key < (Integer) root.getData()) {
                /*将下一次（之后一次）返回的结果设置成为这次递归执行方法root的左孩子*/
                /*为哈是左孩子：因为key<此次的root.getData()，
                下一次肯定是进入了树的左孩子（deleteBST(root.getLeftChild(), key)），所以返回时还是设置成左孩子
                举个例子：找到元素执行完删除时此时返回的root一定是删除结点那最底层的子树根结点，这就是下一次操作
                那么这一次操作假如是这里执行了（此次操作），从左孩子找到了它的待删结点，待删除结点的子树一定是都小于待删除结点的数据（key）
                因此必然让放在此次操作root的左孩子*/

                root.setLeftChild(deleteBST(root.getLeftChild(), key));
                return root;
            } else {
                /*将下一次（之后一次）返回的结果设置成为这次递归执行方法root的又孩子*/
                /*为哈是右孩子：因为key>此次的root.getData()，
                下一次肯定是进入了树的右孩子（deleteBST(root.getRightChild(), key)），所以返回时还是设置成右孩子*/
                root.setRightChild(deleteBST(root.getRightChild(), key));
                return root;
            }
        }
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/31 18:20
     * @param [node]
     * @return search.BiTNode
     * @description 具体的删除操作
     */
    public BiTNode delete(BiTNode node) {


        /*待删除结点分三种情况：
        * 1.叶子结点 2.只有左子树或者右子树 3.既有左子树又有右子树*/
        /*1.待删除结点没有右子树（叶子结点或者只有左子树进入）*/
        if (node.getRightChild() == null) {
            node = node.getLeftChild();     /*得到删除结点之后的子树*/
        } else if (node.getLeftChild() == null) {

            /*2.待删结点没有左子树（只有右子树）*/
            node = node.getRightChild();          /*得到删除结点之后的子树*/
        } else {                     /*3.既有左子树又有右子树*/
            BiTNode s = node.getLeftChild();
            BiTNode q = node;                         /*得到删除结点之后的子树*/
            while (s.getRightChild() != null) {
                q = s;
                s = s.getRightChild();
            }

            node.setData(s.getData());
            if (q != node) {
                q.setRightChild(s.getLeftChild());
            } else {
                q.setLeftChild(s.getLeftChild());
            }
        }


        return node;
    }


    public void inOrderTraverse(BiTNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.getLeftChild());
        System.out.println(root.getData());
        inOrderTraverse(root.getRightChild());
    }

    public BiTNode getRoot() {
        return root;
    }

    public void setRoot(BiTNode root) {
        this.root = root;
    }
}
