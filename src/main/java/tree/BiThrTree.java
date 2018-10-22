package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉线索树
 * @date:2018/10/20
 */
public class BiThrTree {

    private BiThrNode head;  /*头结点,为了方便遍历*/

    private BiThrNode root;  /*根结点*/

    private BiThrNode pre; /*始终指向刚刚访问过的结点*/

    private String[] treeData;
    private int index;

    public BiThrTree() {

    }

    //创建带头结点的线索二叉树
    public BiThrTree(String[] treeData) {
        //通过前序遍历扩展二叉树的序列生成二叉树
        this.treeData = treeData;
        this.index = 0;
        this.root = createBiThrTreePre();
        this.head = new BiThrNode();
        //设置前驱结点的初始值
        this.pre = head;


        //给二叉树添加头结点，先将其左孩子设置成根结点。

        if (root == null) {
            this.head.setlChild(this.head);
            this.head.setlTag(NodeTag.Link);

        } else {
            this.head.setlChild(root);
            this.head.setlTag(NodeTag.Link);


        }

        // 线索化二叉树
        InThreadingWithHead(head);
        //将头结点的右孩子设置成中序遍历的最后一个结点,这部分必须放在线索化后面，
        // 因为线索化方法的递归出口是结点为空，如果在线索化之前设置右孩子，那么会导致线索化方法退出不了，内存溢出
        if (root == null) {
            this.head.setrChild(this.head);
            this.head.setrTag(NodeTag.Link);
        } else {
            this.head.setrTag(NodeTag.Thread);
            this.head.setrChild(findLastWithHead());
        }


    }

    public void createBiThrTree(String[] treeData) {
        //通过前序遍历扩展二叉树的序列生成二叉树
        this.treeData = treeData;
        this.index = 0;
        this.root = createBiThrTreePre();
        this.pre = null;
        InThreading(root);


    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/21 14:28
     * @param [biThrNode]
     * @return void
     * @description 初始化线索，采用中序遍历(带头结点的)
     */
    public void InThreadingWithHead(BiThrNode head) {
        if (head != null) {
            InThreadingWithHead(head.getlChild());  /*递归左子树*/
            if (head.getlChild() == null && head != this.head) {            /*没有左孩子，head != this.head，头结点的左孩子是指向根结点的，不是指向前驱的*/
                head.setlTag(NodeTag.Thread);             /*将标志位设置为线索*/
                head.setlChild(pre);                   /*左孩子指向前驱*/
            }
            if (pre.getrChild() == null && pre != this.head) {        /*前驱如果没有右孩子，pre != this.head，（pre=this.head,修改pre就会影响head）不能修改头结点的右孩子，否则递归会没有出口*/
                pre.setrTag(NodeTag.Thread);
                pre.setrChild(head);         /*前驱右孩子指向当前结点*/
            }
            pre = head;                    /*保持pre指向当前结点的前驱*/
            InThreadingWithHead(head.getrChild());   /*递归右子树*/
        }

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/21 14:28
     * @param [biThrNode]
     * @return void
     * @description 初始化线索，采用中序遍历(没有头结点的)
     */
    public void InThreading(BiThrNode root) {
        if (root != null) {
            InThreading(root.getlChild());  /*递归左子树*/
            if (root.getlChild() == null) {
                root.setlTag(NodeTag.Thread);             /*将标志位设置为线索*/
                root.setlChild(pre);                   /*左孩子指向前驱*/
            }
            if (pre != null && pre.getrChild() == null) {        /*前驱如果没有右孩子*/
                pre.setrTag(NodeTag.Thread);
                pre.setrChild(root);         /*前驱右孩子指向当前结点*/
            }
            pre = root;                    /*保持pre指向当前结点的前驱*/
            InThreading(root.getrChild());   /*递归右子树*/
        }

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
    public BiThrNode createBiThrTreePre() {
        String data = treeData[index];
        System.out.println(treeData[index]);
        index++;
        BiThrNode node;
        if (data.equalsIgnoreCase("#")) {  /*如果在前序输入中是#号代表这个子树创建完毕，返回*/
            node = null;
            return node;
        } else {
            node = new BiThrNode();
            node.setData(data);
            node.setlTag(NodeTag.Link);
            node.setrTag(NodeTag.Link);
            node.setlChild(createBiThrTreePre());  /*和前序遍历一样，进行递归调用，这不过这里对结点的操作不同了*/
            node.setrChild(createBiThrTreePre());
            return node;                           /*最后创建结束返回根结点(因为前序输入第一个结点必然是根结点)*/
        }

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 10:10
     * @param []
     * @return tree.BiThrNode
     * @description 查找中序遍历的第一个结点（中序遍历的规律，第一个结点一定是最后一个左孩子结点）
     */
    public BiThrNode findFirst() {
        BiThrNode p = this.root.getlChild();
        if (p == null) {
            return null;
        }
        while (p.getlChild() != null) {
            p = p.getlChild();
        }
        return p;


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 10:10
     * @param []
     * @return tree.BiThrNode
     * @description 在带有头结点的线索二叉树中查找中序遍历的最后一个结点（中序遍历的规律，最后个结点一定是最后一个右孩子结点）
     */
    public BiThrNode findLastWithHead() {
        BiThrNode p = this.head.getlChild();
        if (p == this.head) {
            return null;
        }
        while (p.getrChild() != this.head) {
            p = p.getrChild();
        }
        return p;


    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 10:10
     * @param []
     * @return tree.BiThrNode
     * @description 在没有头结点的线索二叉树中查找中序遍历的最后一个结点（中序遍历的规律，最后个结点一定是最后一个右孩子结点）
     */
    public BiThrNode findLast() {
        BiThrNode p = this.root.getlChild();
        if (p == null) {
            return null;
        }
        while (p.getrChild() != null) {
            p = p.getrChild();
        }
        return p;


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 14:52
     * @param
     * @return
     * @description 线索二叉树的遍历（找后继右前向后依次进行中序遍历，由于有头结点的存在，也可以更快从最后一个结点找前驱由后向前遍历）
     */

    public void inOrderTraverse_Thr() {
        BiThrNode p = head.getlChild();
        while (p != head) {         /*p==head（空树或者遍历结束）*/
            while (p.getlTag() == NodeTag.Link) {        /*找到中序遍历的第一个结点*/
                p = p.getlChild();
            }
            System.out.println(p.getData());             /*打印出中序遍历的第一个结点的数据*/

            while (p.getrTag() == NodeTag.Thread && p.getrChild() != head) {     /*从中序遍历的第一个结点逐个查找后继*/
                p = p.getrChild();
                System.out.println(p.getData());
            }

            p = p.getrChild();    /*p行进至其右子树根，因为是中序遍历，所以当遍历到当前结点时，它的左子树是全部遍历结束的*/
        }


    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 17:42
     * @param
     * @return
     * @description 不用头结点，也可以从最后一个结点找前驱由后向前遍历(逆向遍历)，只不过要先去找到最后一个结点（在结点比较多的时候会浪费一点时间）
     */

    public void inOrderTraverse_Thr_Reverse() {
        BiThrNode p = head.getlChild();


        while (p != head) {         /*p==head（空树或者遍历结束）*/
            while (p.getrTag() == NodeTag.Link) {        /*找到中序遍历的第一个结点*/
                p = p.getrChild();
            }
            System.out.println(p.getData());             /*打印出中序遍历的第一个结点的数据*/


            while (p.getlTag() == NodeTag.Thread && p.getlChild() != head) {     /*从中序遍历的第一个结点逐个查找后继*/
                p = p.getlChild();
                System.out.println(p.getData());
            }

            p = p.getlChild();    /*p行进至其右子树根，因为是中序遍历，所以当遍历到当前结点时，它的左子树是全部遍历结束的*/
        }

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/10/22 17:42
     * @param
     * @return
     * @description 由于有头结点的存在，也可以更快从最后一个结点找前驱由后向前遍历(逆向遍历)
     */

    public void inOrderTraverse_Thr_Reverse_2() {


        BiThrNode p = head.getrChild();
        System.out.println(p.getData());             /*打印出中序遍历的第一个结点的数据*/
        while (p != head) {         /*p==head（空树或者遍历结束）*/


            while (p.getlTag() == NodeTag.Thread && p.getlChild() != head) {     /*从中序遍历的第一个结点逐个查找后继*/
                p = p.getlChild();
                System.out.println(p.getData());
            }

            p = p.getlChild();    /*p行进至其右子树根，因为是中序遍历，所以当遍历到当前结点时，它的左子树是全部遍历结束的*/
        }

    }

    public void inOrderTraverse_Thr_No_Head() {
        BiThrNode p = root;
        while (p != null) {

            while (p.getlTag() == NodeTag.Link) {
                p = p.getlChild();
            }
            System.out.println(p.getData());
            while (p.getrTag() == NodeTag.Thread && p.getrChild() != null) {
                p = p.getrChild();
                System.out.println(p.getData());
            }
            p = p.getrChild();
        }
    }

    public void inOrderTraverse_Thr_No_Head_Reverse() {
        BiThrNode p = root;
        while (p != null) {

            while (p.getrTag() == NodeTag.Link && p.getrChild() != null) {
                //p.getrChild() != null,因为在创建树时吗，默认将所有结点的两个标志位都设置为Link,
                // 而在线索化时只有最后一个结点的rTag不会被修改，其他结点都会被正确的修改
                p = p.getrChild();
            }
            System.out.println(p.getData());
            while (p.getlTag() == NodeTag.Thread && p.getlChild() != null) {
                p = p.getlChild();
                System.out.println(p.getData());
            }
            p = p.getlChild();
        }
    }


    public BiThrNode getRoot() {
        return root;
    }

    public void setRoot(BiThrNode root) {
        this.root = root;
    }
}
