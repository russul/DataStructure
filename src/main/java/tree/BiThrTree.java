package tree;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 二叉线索树
 * @date:2018/10/20
 */
public class BiThrTree {

    private BiThrNode head;  /*头结点,为了方便遍历*/

    private BiThrNode pre; /*始终指向刚刚访问过的结点*/

    private String[] treeData;
    private int index;

    public BiThrTree() {
        this.head = new BiThrNode();
        this.pre = new BiThrNode();
        head.setlTag(NodeTag.Link);
        head.setlChild(createBiThrTreePre());
        InThreading(head.getlChild());
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/21 14:28
     * @param [biThrNode]
     * @return void
     * @description 初始化线索，采用中序遍历
     */
    public void InThreading(BiThrNode biThrNode) {
        if (biThrNode != null) {
            InThreading(biThrNode.getlChild());  /*递归左子树*/
            if (biThrNode.getlChild() == null) {            /*没有左孩子*/
                biThrNode.setlTag(NodeTag.Thread);             /*将标志位设置为线索*/
                biThrNode.setlChild(pre);                   /*左孩子指向前驱*/
            }
            if (pre.getrChild() == null) {        /*前驱如果没有右孩子*/
                pre.setrTag(NodeTag.Thread);
                pre.setrChild(biThrNode);         /*前驱右孩子指向当前结点*/
            }
            pre = biThrNode;                    /*保持pre指向当前结点的前驱*/
            InThreading(biThrNode.getrChild());   /*递归右子树*/
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
}
