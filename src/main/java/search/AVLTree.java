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

    private boolean taller = false;

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
                if (root.getLeftChild() == null) {
                    return root;
                }

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
                if (root.getRightChild() == null) {
                    return root;
                }
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

    public AVLTNode getRoot() {
        return root;
    }

    public void setRoot(AVLTNode root) {
        this.root = root;
    }
}
