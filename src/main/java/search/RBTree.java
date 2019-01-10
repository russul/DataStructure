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


    /*
     *
     *
     * @author kevin
     * @date 2019/1/9 0009 22:08
     * @param [x]
     * @return search.RBNode(返回左旋后的根节点即形参x的右孩子)
     * @description
     */
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

    /*
     *
     *
     * @author kevin
     * @date 2019/1/9 0009 22:07
     * @param [x]
     * @return search.RBNode(返回右旋后的根节点即形参x的左孩子)
     * @description
     */
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
                        RBNode leftRotateRoot = leftRotate(z);
                        z.parent.parent.left = leftRotateRoot;
                        leftRotateRoot.parent = z.parent.parent;
                    }
                    //case3
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    RBNode rightRotateRoot;
                    if (z.parent.parent == z.parent.parent.parent.left) {
                        //为了右旋返回值设置成左孩子还是右孩子，要记录z的曾祖父
                        RBNode parent = z.parent.parent.parent;
                        rightRotateRoot = rightRotate(z.parent.parent);

                        parent.left = rightRotateRoot;
                        rightRotateRoot.parent = parent;

                    } else {
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
                        RBNode rightRotateRoot = rightRotate(z);
                        z.parent.parent.right = rightRotateRoot;
                        rightRotateRoot.parent = z.parent.parent;
                    }

                    z.parent.color = false;
                    z.parent.parent.color = true;
                    RBNode leftRotateRoot;
                    if (z.parent.parent == z.parent.parent.parent.left) {
                        RBNode parent = z.parent.parent.parent;
                        leftRotateRoot = leftRotate(z.parent.parent);

                        parent.left = leftRotateRoot;
                        leftRotateRoot.parent = parent;

                    } else {
                        RBNode parent = z.parent.parent.parent;
                        leftRotateRoot = leftRotate(z.parent.parent);

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


    public void RBDelete(RBNode z) {
        RBNode y = z;
        RBNode x;

        //记录待删除结点颜色值（为了后面修复红黑树性质做准备），因为颜色的变化会破坏原有红黑树的性质
        boolean y_original_color = y.color;

        if (z.left == NIL) {   //待删除节点的左孩子是NIL，将z.right取代z的位置即可
            x = z.right;
            RBTransplant(z, z.right);
        } else if (z.right == NIL) {     //待删除节点的右孩子是NIL，将z.left取代z的位置即可
            x = z.left;
            RBTransplant(z, z.left);
        } else {

            //如果带删除结点既有左孩子又有右孩子
            //寻找取代z位置的节点（中序遍历的前一个或者后一个相邻结点，这里采用后一个相邻结点）
            //这个点必然是z右孩子的最左结点或者是z的右孩子（当右孩子没有左子树时）
            y = TreeMinimum(z.right);

            //更新颜色的变化
            y_original_color = y.color;
            //需要将y的左子树移动到
            x = y.right;
            //y是z右孩子情景
            if (y.parent == z) {
                x.parent = y;
            } else {
                //y是z右孩子最左结点情景
                //先删除y结点（待会y结点会取代z的位置，相当于后面的结构中删除了y）
                RBTransplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            //两种情况统一用y取代z的位置完成删除z结点的操作
            RBTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;


        }

        //根据y_original_color是黑色（删除的结点时黑色的，那么黑高相等的性质一定被破坏了），需要修复红黑树的性质；
        // 如果是红色则不会破坏红黑树的性质
        if (y_original_color == false) {
            RBDelete_FixUp(x);
        }
    }



    /*
     *
     *
     * @author kevin
     * @date 2019/1/9 0009 22:12
     * @param RBNode x：待删除结点的右孩子
     * @return ：待删除结点的中序遍历的后一个相邻结点
     * @description 寻找待删除结点的中序遍历的后一个节点（为了方便删除节点做铺垫）
     */

    private RBNode TreeMinimum(RBNode x) {
        while (x.left != NIL) {
            x = x.left;
        }

        return x;
    }


    /*
     *
     *
     * @author kevin
     * @date 2019/1/9 0009 22:06
     * @param [u, v]   （u是待删除节点，v是取代u位置的节点）
     * @return void
     * @description 删除节点的变形过程
     */
    private void RBTransplant(RBNode u, RBNode v) {


        if (u.parent == NIL) {   //待删除结点是根节点
            root = v;

        } else if (u == u.parent.left) {   //待删除结点时父节点的左孩子，就让v取代相应位置
            u.parent.left = v;
        } else {
            u.parent.right = v;

        }

        v.parent = u.parent;     //统一设置v的父节点改为待删结点的父节点
    }


    /*
     *
     *
     * @author kevin
     * @date 2019/1/9 0009 22:47
     * @param [x]:取代结点的右孩子(在删除结点时要先用该结点取代 取代结点)（因为出问题必然在取代结点的右子树上），此时待删除结点已经被删除了
     * @return void
     * @description:修复因为删除节点造成的红黑树性质破坏（根节点必须是黑色和各路径上的黑高相同）
     * 引入两个概念：双重黑色与红黑色，
     * 是为了解决删除结点而造成的黑高不足，额外给结点添加一层黑色（这和结点的color属性值不同），修护关系就是通过操作去掉这层额外的黑色
     * 双层黑色结点：该结点要贡献两个黑结点（它的color属性黑色+额外的一个虚拟的黑色=2）
     * 红黑色结点：该结点只贡献一个黑结点（它的color属性为红色+额外的一个虚拟的黑色=1）
     */
    private void RBDelete_FixUp(RBNode x) {
        RBNode w;

        RBNode leftRotateRoot;
        RBNode rightRotateRoot;
        RBNode grandParent = x.parent.parent;

        //循环终止条件x如果是红色的，它之上的红黑树性质没有被破坏
        while (x != root && x.color == false) {   //一旦进入循环时x必然是双重黑色的
            if (x == x.parent.left) {

                w = x.parent.right;


                //有四种情景
                //1.x的兄弟结点w是红色的：x.parent进行左旋并改变w和x.parent的颜色变为情景2
                //2.x的兄弟结点w是黑色的且w的两个子结点都是黑色的：让x去掉一重黑色的措施就是将w变为红色
                //3.x的兄弟结点w是黑色的且w的左孩子是红色的，右孩子是黑色的：交换w和w.left的颜色进行右旋变为情景4
                //4.x的兄弟结点w是黑色的且w的右孩子是红色的：将w和w.right的颜色交换，做一次左旋操作
                //1-->2;3-->4;只要处理2,4两种情况即可
                if (w.color == true) {
                    //case1
                    w.color = false;
                    x.parent.color = true;

//                    RBNode grandParent = x.parent.parent;
                    leftRotateRoot = leftRotate(x.parent);

                    leftRotateRoot.parent = grandParent;
                    if (x.parent == grandParent.left){
                        grandParent.left = leftRotateRoot;
                    }else {
                        grandParent.right = leftRotateRoot;
                    }

                    w = x.parent.right;
                }

                if (w.left.color == false && w.right.color == false) {
                    //case2
                    //让x去掉一重黑色的措施就是将w变为红色，这样为了补偿x和w上去除的一层黑色就需要给x.parent加上一个额外的黑色，继续迭代
                    w.color = true;
                    x = x.parent;
                } else {
                    //case3
                    if (w.right.color == false) {
                        w.left.color = false;
                        w.color = true;
                        rightRotateRoot = rightRotate(w);
                        rightRotateRoot.parent = x.parent;
                        x.parent.right = rightRotateRoot;
                        w = x.parent.right;
                    }

                    //case4
                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.right.color = false;
                    leftRotateRoot = leftRotate(x.parent);
                    x.parent.parent = leftRotateRoot;
                    leftRotateRoot.left = x.parent;
                    x = root;
                }


            } else {
                w = x.parent.left;

                if (w.color == true) {
                    //case1
                    w.color = false;
                    x.parent.color = true;
                    rightRotateRoot=rightRotate(x.parent);
                    rightRotateRoot.parent = grandParent;
                    if (x.parent == grandParent.left){
                        grandParent.left = rightRotateRoot;
                    }else {
                        grandParent.right = rightRotateRoot;
                    }
                    w = x.parent.left;
                }
                if (w.left.color == false && w.right.color == false) {
                    //case2
                    w.color = true;
                    x = x.parent;
                } else {
                    //case3:左孩子黑色，右孩子红色
                    if (w.left.color == false) {
                        w.right.color = false;
                        w.color = true;
                        leftRotateRoot=leftRotate(w);
                        x.parent.left = leftRotateRoot;
                        x.parent = leftRotateRoot.parent;
                        w = x.parent.left;
                    }

                    //case4:w的左孩子是红色
                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.left.color = false;
                    rightRotateRoot=rightRotate(x.parent);
                    x.parent.parent = rightRotateRoot;
                    rightRotateRoot.right = x.parent;
                    //修复完成，退出
                    x = root;
                }
            }



        }

        //修复节点不是黑色的性质
        x.color = false;
    }

}
