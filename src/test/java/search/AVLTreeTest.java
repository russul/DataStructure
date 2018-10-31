package search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/31
 */
public class AVLTreeTest {


    private AVLTree avlTree;

    @Before
    public void setUp() {
        avlTree = new AVLTree();
    }

    @Test
    public void rightRotate() {
    }

    @Test
    public void leftRotate() {
    }

    @Test
    public void leftBalance() {
    }

    @Test
    public void rightBalance() {
    }

    @Test
    public void insertAVL() {

        int[] aa = {3,2,1};
        for (int a:aa
             ) {
            avlTree.setRoot(avlTree.insertAVL(avlTree.getRoot(), a));
        }

    }

    @Test
    public void getRoot() {
    }

    @Test
    public void setRoot() {
    }
}