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



        tree.RBInsert(node);
        tree.RBInsert(node1);
        tree.RBInsert(node2);
        tree.RBInsert(node3);
        tree.RBInsert(node4);
        tree.RBInsert(node5);
        tree.RBInsert(node6);

        tree.toString();


    }
}