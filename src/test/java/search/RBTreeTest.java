package search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2019/1/8 0008
 */
public class RBTreeTest {

    @Test
    public void RBInsert() {

        RBTree tree = new RBTree();

        RBNode node = new RBNode(10,true);
        RBNode node1 = new RBNode(14,true);
        RBNode node2 = new RBNode(20,true);
        RBNode node3 = new RBNode(2,true);
        RBNode node4 = new RBNode(5,true);
        RBNode node5 = new RBNode(1,true);
        RBNode node6 = new RBNode(7,true);
        RBNode node7 = new RBNode(12,true);
        RBNode node8 = new RBNode(25,true);
        RBNode node9 = new RBNode(23,true);
        RBNode node10 = new RBNode(33,true);
        RBNode node11 = new RBNode(21,true);



        tree.RBInsert(node);
        tree.RBInsert(node1);
        tree.RBInsert(node2);
        tree.RBInsert(node3);
        tree.RBInsert(node4);
        tree.RBInsert(node5);
        tree.RBInsert(node6);
        tree.RBInsert(node7);
        tree.RBInsert(node8);
        tree.RBInsert(node9);
        tree.RBInsert(node10);
        tree.RBInsert(node11);

//        tree.RBDelete(node10);
//        tree.RBDelete(node2);

        tree.RBDelete(node1);

        tree.toString();


    }
}