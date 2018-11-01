package search;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/31
 */
public class AVLTree {

    public static final int LH = 1;      /*左侧高*/
    public static final int EH = 0;   /*左右相等*/
    public static final int RH = -1;    /*右侧高（深）*/
    private AVLTNode root;

    private boolean taller = false;    /*判断当前树是否长高*/

    public AVLTNode rightRotate(AVLTNode p) {
        AVLTNode l = p.getLeftChild();
        p.setLeftChild(l.getRightChild());
        l.setRightChild(p);
        p = l;
        return p;
    }


    public AVLTNode leftRotate(AVLTNode p) {
        AVLTNode r = p.getRightChild();
        p.setRightChild(r.getLeftChild());
        r.setLeftChild(p);
        p = r;

        return p;
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/1 21:17
     * @param [root]
     * @return search.AVLTNode
     * @description 左平衡旋转处理，返回值指向新的根节点
     */
    public AVLTNode leftBalance(AVLTNode root) {
        AVLTNode L = root.getLeftChild();
        switch (L.getBalanceFactor()) {
            case LH: {
                root.setBalanceFactor(EH);
                L.setBalanceFactor(EH);
                root = rightRotate(root);
                break;
            }
            case RH: {

                AVLTNode Lr = L.getRightChild();

                switch (Lr.getBalanceFactor()) {
                    case LH: {
                        root.setBalanceFactor(RH);
                        L.setBalanceFactor(EH);
                        break;
                    }
                    case EH: {
                        root.setBalanceFactor(EH);
                        L.setBalanceFactor(EH);
                        break;
                    }
                    case RH: {
                        root.setBalanceFactor(EH);
                        L.setBalanceFactor(LH);
                        break;
                    }
                }

                Lr.setBalanceFactor(EH);
                root.setLeftChild(leftRotate(root.getLeftChild()));
                root = rightRotate(root);

            }
        }

        return root;
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/1 21:19
     * @param
     * @return
     * @description 右平衡旋转处理，返回值指向新的根节点
     */

    public AVLTNode rightBalance(AVLTNode root) {

        AVLTNode R = root.getRightChild();

        switch (R.getBalanceFactor()) {
            case RH: {

                root.setBalanceFactor(EH);
                R.setBalanceFactor(EH);
                root = leftRotate(root);
                break;
            }
            case LH: {

                AVLTNode Rl = R.getLeftChild();

                switch (Rl.getBalanceFactor()) {
                    case LH: {
                        root.setBalanceFactor(EH);
                        R.setBalanceFactor(RH);
                        break;
                    }
                    case EH: {
                        root.setBalanceFactor(EH);
                        R.setBalanceFactor(EH);
                        break;
                    }

                    case RH: {
                        root.setBalanceFactor(LH);
                        R.setBalanceFactor(EH);
                        break;
                    }
                }


                Rl.setBalanceFactor(EH);
                root.setRightChild(rightRotate(root.getRightChild()));
                root = leftRotate(root);

            }
        }

        return root;
    }

    public AVLTNode insertAVL(AVLTNode root, int key) {
        if (root == null) {
            root = new AVLTNode();
            root.setBalanceFactor(EH);
            root.setData(key);
            root.setRightChild(null);
            root.setLeftChild(null);
            taller = true;

        } else {
            if (key == (Integer) root.getData()) {
                taller = false;

                return root;
            }

            if (key < (Integer) root.getData()) {
                root.setLeftChild(insertAVL(root.getLeftChild(), key));
//                if (root.getLeftChild() == null) {
//                    return root;
//                }

                if (taller == true) {
                    switch (root.getBalanceFactor()) {
                        case LH: {
                            root = leftBalance(root);
                            taller = false;
                            break;
                        }
                        case EH: {
                            root.setBalanceFactor(LH);
                            taller = true;
                            break;
                        }

                        case RH: {
                            root.setBalanceFactor(EH);
                            taller = false;
                            break;
                        }
                    }
                }
            } else {
                root.setRightChild(insertAVL(root.getRightChild(), key));
//                if (root.getRightChild() == null) {
//                    return root;
//                }
                if (taller == true) {
                    switch (root.getBalanceFactor()) {
                        case LH: {
                            root.setBalanceFactor(EH);
                            taller = false;
                            break;
                        }
                        case EH: {
                            root.setBalanceFactor(RH);
                            taller = true;
                            break;
                        }

                        case RH: {
                            root = rightBalance(root);
                            taller = false;
                            break;
                        }
                    }
                }
            }
        }

        return root;
    }


    /*
     *
     *
     * @author kevin
     * @date 2018/11/1 22:16
     * @param
     * @return
     * @description 插入操作
     */

    public AVLTNode insertAVL2(AVLTNode root, int key) {
        if (root == null) {
            /*插入新结点，树长高taller=true*/
            root = new AVLTNode();
            root.setBalanceFactor(EH);
            root.setData(key);
            root.setRightChild(null);
            root.setLeftChild(null);
            taller = true;
            return root;
        } else {
            if (key == (Integer) root.getData()) {

                /*树中已经存在和key相同的关键字结点，不再插入，树也不长高*/
                taller = false;

                return root;
            }



            if (key < (Integer) root.getData()) {

                /*递归它的左子树，在左子树中进行搜索，将新的树设置为树的左孩子----》这里其实隐含的就是搜索的过程*/
                root.setLeftChild(insertAVL(root.getLeftChild(), key));


                if (taller == true) {    /*已经插入了当前树的左子树中且左子树长高了*/
                    switch (root.getBalanceFactor()) {
                        case LH: {                    /*原本左子树比右子树高，需要做左平衡处理*/
                            root = leftBalance(root);
                            taller = false;
                            break;
                        }
                        case EH: {                        /*原本左子树和右子树等高，现在由于在左子树中添加了结点，左子树会变高*/
                            root.setBalanceFactor(LH);
                            taller = true;
                            break;
                        }

                        case RH: {                    /*原本右子树比左子树高，现在由于在左子树中添加了结点，左右等高*/
                            root.setBalanceFactor(EH);
                            taller = false;
                            break;
                        }
                    }
                }

                return root;
            } else {


                /*递归它的右子树，在右子树中进行搜索，将新的树设置为树的右孩子*/
                root.setRightChild(insertAVL(root.getRightChild(), key));

                if (taller == true) {           /*已经插入了当前树的右子树中且右子树长高了*/
                    switch (root.getBalanceFactor()) {
                        case LH: {                     /*原本左子树比右子树高，现在由于在右子树中添加了结点，左右等高*/
                            root.setBalanceFactor(EH);
                            taller = false;
                            break;
                        }
                        case EH: {                      /*原本左子树和右子树等高，现在由于在右子树中添加了结点，右子树会变高*/
                            root.setBalanceFactor(RH);
                            taller = true;
                            break;
                        }

                        case RH: {                       /*原本右子树比左子树高，现在由于在右子树中添加了结点，右平衡处理*/
                            root = rightBalance(root);
                            taller = false;
                            break;
                        }
                    }
                }
            }

            return root;
        }


    }

    public void inOrderTraverse(AVLTNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.getLeftChild());
        System.out.println(root.getData());
        inOrderTraverse(root.getRightChild());
    }

    public AVLTNode getRoot() {
        return root;
    }

    public void setRoot(AVLTNode root) {
        this.root = root;
    }
}
