package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2019/1/7 红黑树
 */
public class RBTree {

    public RBNode root;
    //哨兵节点（所有的叶节点都指向他（取代了原理二叉树中的null位置），根节点的父节点也指向它；它的左右孩子规定均指向根节点）
    public static final RBNode NIL = new RBNode(Integer.MAX_VALUE, false);



    public RBTree() {
        this.root = NIL;
    }

    private RBNode leftRotate(RBNode x) {
        RBNode y = x.right;


        x.right = y.left;
        if (y.left != NIL) {
            y.left.parent = x;
        }
        //设置y新的父节点
        y.parent = x.parent;

        //根据同情况设置x.parent的属性
        if (x.parent == NIL) {    //x是根节点
            root = y;
            NIL.left = NIL.right = y;
        } else if (x == x.parent.left) {     //x是父节点的左节点
            x.parent.left = y;
        } else {        //x是父节点的右节点
            x.parent.right = y;
        }

        //设置y新的左节点（左旋不需要处理y的右节点）
        y.left = x;
        x.parent = y;
        return y;
    }

    private RBNode rightRotate(RBNode x) {
        RBNode y = x.left;


        //设置x.left和y.right的双向关系
        x.left = y.right;
        if (y.right != NIL) {
            y.right.parent = x;
        }
        //设置y新的父节点（y和x.parent的双向关系）
        y.parent = x.parent;


        if (x.parent == NIL) {    //x是根节点
            root = y;
            NIL.left = NIL.right = y;
        } else if (x == x.parent.left) {     //x是父节点的左节点
            x.parent.left = y;
        } else {        //x是父节点的右节点
            x.parent.right = y;
        }

        //设置y新的右节点(y和x的双向关系)（左旋不需要处理y的左节点）
        y.right = x;
        x.parent = y;
        return y;
    }


    /*
     *
     *
     * @author kevin
     * @date 2019/1/8 0008 16:46
     * @param [z]
     * @return void
     * @description 插入节点操作
     * （由于红黑树节点中有父节点和子节点的双向关系，所以在寻找待插入的位置时不需要递归而直接使用迭代即可）
     */
    public void RBInsert(RBNode z) {
        RBNode y = NIL;
        RBNode x = root;

        //寻找节点待插入的父节点位置（y节点表示）
        while (x != NIL) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;


        if (y == NIL) {      //插入第一个节点时在，设置规定
            root = z;
            NIL.left = NIL.right = root;
        } else if (z.key < y.key) {
            y.left = z;

        } else {
            y.right = z;
        }

        z.left = NIL;
        z.right = NIL;

        z.color = true;

        RBInsert_FixUp(z);


    }


    /*
     *
     *
     * @author kevin
     * @date 2019/1/8 0008 16:44
     * @param [z]
     * @return void
     * @description 修复红黑树（通过旋转和改变着色）
     */
    private void RBInsert_FixUp(RBNode z) {
        //循环终止条件就是待插入节点的父节点是黑色的
        while (z.parent.color) {

            //插入节点的父节点是祖父节点的左孩子（有3种情况）
            //1.待插入节点z的叔节点是红色的
            // 2.z的叔节点是黑色的，且z是父节点的右孩子
            // 3.z的叔节点是黑色的，且z是父节点的左孩子
            //其中2和3是可以相互转换的，2-->3左旋;3-->2右旋（而且不会破坏黑高的性质）
            if (z.parent == z.parent.parent.left) {
                RBNode y = z.parent.parent.right;

                //case1
                if (y.color) {
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {

                    //case2
                    if (z == z.parent.right) {
                        z = z.parent;
                        RBNode leftRotateRoot= leftRotate(z);
                        z.parent.parent.left = leftRotateRoot;
                        leftRotateRoot.parent = z.parent.parent;
                    }
                    //case3
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    RBNode rightRotateRoot;
                    if (z.parent.parent==z.parent.parent.parent.left){
                        //为了右旋返回值设置成左孩子还是右孩子，要记录z的曾祖父
                        RBNode parent = z.parent.parent.parent;
                        rightRotateRoot = rightRotate(z.parent.parent);

                        parent.left = rightRotateRoot;
                        rightRotateRoot.parent = parent;

                    }else {
                        RBNode parent = z.parent.parent.parent;
                        rightRotateRoot = rightRotate(z.parent.parent);

                        parent.right = rightRotateRoot;
                        rightRotateRoot.parent = parent;
                    }


                }
            } else {

                //同理，当z的父节点是祖父节点右孩子同样有3种情况

                RBNode y = z.parent.parent.left;

                if (y.color) {
                    z.parent.color = false;
                    y.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        RBNode rightRotateRoot= rightRotate(z);
                        z.parent.parent.right = rightRotateRoot;
                        rightRotateRoot.parent = z.parent.parent;
                    }

                    z.parent.color = false;
                    z.parent.parent.color = true;
                    RBNode leftRotateRoot;
                    if (z.parent.parent==z.parent.parent.parent.left){
                        RBNode parent = z.parent.parent.parent;
                        leftRotateRoot = leftRotate(z.parent.parent);

                        parent.left = leftRotateRoot;
                        leftRotateRoot.parent = parent;

                    }else {
                        RBNode parent = z.parent.parent.parent;
                        leftRotateRoot = rightRotate(z.parent.parent);

                        parent.right = leftRotateRoot;
                        leftRotateRoot.parent = parent;
                    }

                }
            }
        }

        //为了防止插入的节点就是第一个节点，
        // 如果直接插入它是红色的，会违背根节点是黑色的性质，因此这里将根节点设置为黑色
        root.color = false;
    }

}
