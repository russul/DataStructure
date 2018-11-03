package search;

import com.sun.xml.internal.ws.api.model.MEP;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/11/2
 */
public class BTree {

    public static final int DEGREE = 4;

    private BTNode root;


    private int t;    /*该B树非根结点最小的度*/

    /*初始化一棵空树，存储0个元素就标志着是空树*/
    public BTree() {
        root = new BTNode();
        root.setN(0);
        root.setLeaf(true);
        if (DEGREE % 2 == 0) {
            t = DEGREE / 2;
        } else {
            t = DEGREE / 2 + 1;
        }
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/2 17:25
     * @param [root, key, current]
     * @return search.BTNode
     * @description 返回的是current是查询到元素所在的结点，如果没有current=null.
     */
    public BTNode searchBT(BTNode root, int key, BTNode current) {


        if (root == null) {
            return null;

        } else {
            /*查询到则放回该结点*/
            for (Integer data : root.getKeys()
                    ) {
                if (data.equals(key)) {
                    current = root;
                    return current;
                }
            }

            /*找到小于key的最小下标，因为接下来要从最小下标包括他之后指针所指向的孩子递归查询*/
            int min = 0;
            while (min < root.getKeys().size() && key > root.getKeys().get(min)) {
                min++;
            }

            if (root.getChildren().size() == 0) {   /*到达叶子结点还没找到，返回null*/
                return null;

            }

            /*递归查询*/
            return searchBT(root.getChildren().get(min), key, current);

        }


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/2 18:44
     * @param [root：当前根结点, key：关键字, current（用于返回）, parent（当前根结点的双亲结点，上一个结点）]
     * @return current:查询成功返回查询到的结点
     *                  失败返回访问它路径上的最后一个结点（如果该元素存在，那么它的上一个结点）
     * @description
     */
    public BTNode searchBT(BTNode root, int key, BTNode current, BTNode parent) {


        if (root == null) {

            /*查询失败，返回路径上的最后一个结点*/
            current = parent;

            return current;

        } else {
            /*查询到则放回该结点*/
            for (Integer data : root.getKeys()
                    ) {
                if (data.equals(key)) {
                    /*查询成功，返回当前结点*/
                    current = root;
                    return current;
                }
            }

            /*找到小于key的最小下标，因为接下来要从最小下标包括他之后指针所指向的孩子递归查询*/
            int min = 0;
            while (min < root.getKeys().size() && key > root.getKeys().get(min)) {
                min++;
            }

            if (root.getChildren().size() == 0) {   /*到达叶子结点还没找到，返回null*/

                /*查询失败，返回路径上的最后一个结点*/
                current = root;
                return current;

            }

            /*递归查询*/
            return searchBT(root.getChildren().get(min), key, current, root);

        }


    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/2 17:25
     * @param [root, key, current]
     * @return search.BTNode
     * @description 返回的是查询到(key,i):i是在结点中索引
     */
    public void searchBT(BTNode root, int key) {
        if (root == null) {

            return;
        } else {


            for (Integer data : root.getKeys()
                    ) {
                if (data.equals(key)) {
                    System.out.println("(" + data + "," + root.getKeys().indexOf(data) + ")");
                }
            }
            int min = 0;
            while (min < root.getKeys().size() && key > root.getKeys().get(min)) {
                min++;
            }

            if (root.getChildren().size() == 0) {

                return;
            }

            searchBT(root.getChildren().get(min), key);

        }


    }


    public BTNode insertBT(BTNode root, int key) {

        /*如果该结点是满结点，先分裂在插入*/
        if (root.getN() + 1 == DEGREE) {
            BTNode s = new BTNode();
            s.getChildren().add(root);
            s.setN(0);

            spiltBT(s, 0);
            root = insertNonFull(s, key);
        } else {
            /*该结点不是满结点直接插入*/
            root = insertNonFull(root, key);

        }
        return root;
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/3 15:58
     * @param
     * @return
     * @description 插入一个非满结点，传入的s是一个非满结点
     */

    private BTNode insertNonFull(BTNode s, int key) {


        /*如果找树中有该关键字，那么就不插入（不修改s）也不继续遍历查询，直接返回该结点*/
        for (int k = 0; k < s.getKeys().size(); k++) {
            if (key == s.getKeys().get(k)) {
                return s;
            }

        }


        int i = s.getN() - 1;
        /*递归的出口条件，找到传入的key应该插入的叶子结点，进行插入*/
        if (s.getChildren().size() == 0) {

            /*找到插入关键字的合适位置*/
            /*将s的key的集合长度加1，填的值可以是任意的，无影响*/
            s.getKeys().add(1);
            while (i >= 0 && key < s.getKeys().get(i)) {
                s.getKeys().set(i + 1, s.getKeys().get(i));
                i--;
            }

            s.getKeys().set(i + 1, key);
            s.setN(s.getN() + 1);

            return s;

        } else {
            /*没有找到该元素应该插入的叶子结点就一直递归查找子树*/
            /*这里找到应该从哪个子树进行递归*/
            while (i >= 0 && key < s.getKeys().get(i)) {
                i--;
            }



            /*i就查找key要进行递归的子树索引（在子结点不用分裂的情况下）*/
            i = i + 1;

            BTNode x = s.getChildren().get(i);
            /*在递归之前先对结点进行判断，如果是满结点就执行分裂操作*/
            if (x.getN() + 1 == DEGREE) {

                s = spiltBT(s, i);
                /*分裂会在父节点中增加一个key,其索引是i,这时候就需要判断传入的key和该位置的可以大小来修改要递归的子树索引*/
                if (key > s.getKeys().get(i)) {
                    i = i + 1;
                }

            }

            /*执行递归查询插入操作，由于上面的操作确保这里每次都传入的是个非满结点*/
            insertNonFull(s.getChildren().get(i), key);

            return s;
        }

    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/3 15:36
     * @param [node, i]
     * @return search.BTNode
     * @description 满结点的分裂，是B树中唯一让树长高的方式，
     * 传入的node是非满结点，node的第(i+1)个孩子是满结点，实际上是分裂node的第(i+1)个孩子
     */
    public BTNode spiltBT(BTNode node, int i) {

        /*得到给满结点，之后把它作为一个分裂结点*/
        BTNode spilt1 = node.getChildren().get(i);

        /*我么可以计算出来结点最小的度,也是分裂点的位置*/
        int t;
        if (spilt1.getN() % 2 == 0) {
            t = spilt1.getN() / 2;
        } else {
            t = spilt1.getN() / 2 + 1;
        }



        /*第二个分裂结点*/
        BTNode spilt2 = new BTNode();
        /*第二个分裂结点存储的元素个数*/
        spilt2.setN(t - 1);
        /*将满结点的中间元素靠后的t-1个元素给新建的第二个分裂结点*/
        for (int j = 0; j < t - 1; j++) {
            spilt2.getKeys().add(spilt1.getKeys().get(j + t));
        }

        /*如果满结点不是叶子结点，还要它的从t开始之后的孩子同样给第二个分裂点*/
        if (spilt1.getChildren().size() != 0) {
            for (int j = 0; j < t; j++) {
                spilt2.getChildren().add(spilt1.getChildren().get(j + t));
            }
        }


        /*接下来将满结点处理为第一个分裂结点*/

        /*设置第一个分裂点的存储元素个数*/
        spilt1.setN(t - 1);

        /*删除t后面的关键字，保留下标为t的关键字（中间关键字），后续赋值后再删除*/
        while (spilt1.getKeys().size() > t) {
            spilt1.getKeys().remove(t);
        }
        /*删除多余的孩子结点*/
        while (spilt1.getChildren().size() > t) {
            spilt1.getChildren().remove(t);
        }


        /*将满结点的父节点的孩子结点的长度增加1*/
        node.getChildren().add(new BTNode());

        /*让node结点的孩子指针从i+1开始都向后一位，为了腾一个位置给从分裂多出来的一个结点*/
        for (int j = node.getN(); j >= i + 1; j--) {
            node.getChildren().set(j + 1, node.getChildren().get(j));
        }

        /*将腾出的孩子结点位置连接新建的第二个分裂点*/
        node.getChildren().set(i + 1, spilt2);

        /*将key的集合长度+1*/
        node.getKeys().add(1);
        /*将关键字也向后移动一位，从i开始*/

        for (int j = node.getN() - 1; j >= i; j--) {
            node.getKeys().set(j + 1, node.getKeys().get(j));
        }

        /*腾出来的关键字地方赋值因为分裂而从满结点中出来的那个关键字*/
        node.getKeys().set(i, spilt1.getKeys().get(t - 1));
        /*从spilt1中把分裂出来的关键字去除*/
        spilt1.getKeys().remove(t - 1);

        /*将node的存储元素个数+1*/
        node.setN(node.getN() + 1);

        return node;

    }

    /*
     *
     *
     * @author kevin
     * @date 2018/11/2 17:29
     * @param [root]
     * @return void
     * @description B树的中序遍历
     */
    public void inOrderTraverse(BTNode root) {
        if (root.getChildren().size() == 0) {    /*如果是叶子结点就输出key然后返回，是递归的出口*/
            for (int key : root.getKeys()
                    ) {
                System.out.println(key);
            }
            return;
        }


        int i = 0;
        while (i < root.getChildren().size()) {     /*对root的孩子依次做遍历，但这里面要注意当前根结点的输出问题*/

            int j = i;    /*count为了记录当前是从当前根结点那个孩子结点递归的*/
            inOrderTraverse(root.getChildren().get(i++));


            /*尤其关键字的长度比孩子树少1，最后一次孩子结点遍历返回后不需要再度根结点数据了，因为已经读完了，不加限制会出现数组下标溢出*/
            if (j != root.getKeys().size()) {
                System.out.println(root.getKeys().get(j));    /*每一次递归返回的后，输出根结点相应位置的关键字*/
            }


        }

    }


    public void deleteBT(BTNode root, int key) {


        if (root.getChildren().size() == 0) {

            /*在叶子结点中找到*/
            for (int i = 0; i < root.getKeys().size(); i++) {

                if (key == root.getKeys().get(i)) {
                    root.getKeys().remove(i);
                    root.setN(root.getN() - 1);
                    return;


                }
            }
//           /*树中不存在没有找到*/
            return;

        } else {

            for (int i = 0; i < root.getKeys().size(); i++) {
                /*在非叶结点中找到*/
                if (key == root.getKeys().get(i)) {

                    BTNode y = root.getChildren().get(i);
                    if (y.getN()>=t){
                        delete(y,key);
                    }


                }
            }
        }


        /*在叶子结点中找到*/
        for (int i = 0; i < root.getKeys().size(); i++) {

            if (key == root.getKeys().get(i)) {
                if (root.getChildren().size() == 0) {
                    root.getKeys().remove(i);
                    root.setN(root.getN() - 1);
                    return;
                } else {

                }


            }

            return;
        }


    }

    private void delete(BTNode y, int key) {


    }

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
}
