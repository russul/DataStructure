package search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/11/2
 */
public class BTreeTest {

    @Test
    public void searchBT() {

        BTree bTree = new BTree();
        BTNode node = new BTNode(2, 16, 30);
        BTNode node1 = new BTNode(3, 3, 5, 10);
        BTNode node2 = new BTNode(1, 20);
        BTNode node3 = new BTNode(1, 35);
        BTNode node4 = new BTNode(2, 1, 2);
        BTNode node5 = new BTNode(1, 4);
        BTNode node6 = new BTNode(2, 6, 7);
        BTNode node7 = new BTNode(1, 15);
        BTNode node8 = new BTNode(1, 19);
        BTNode node9 = new BTNode(2, 21, 25);
        BTNode node10 = new BTNode(1, 32);
        BTNode node11 = new BTNode(1, 40);

        node1.getChildren().add(node4);
        node1.getChildren().add(node5);
        node1.getChildren().add(node6);
        node1.getChildren().add(node7);

        node2.getChildren().add(node8);
        node2.getChildren().add(node9);


        node3.getChildren().add(node10);
        node3.getChildren().add(node11);

        node.getChildren().add(node1);
        node.getChildren().add(node2);
        node.getChildren().add(node3);

        bTree.setRoot(node);
        bTree.inOrderTraverse(bTree.getRoot());

        BTNode current = bTree.searchBT(bTree.getRoot(), 9, null);

        bTree.searchBT(bTree.getRoot(), 9);
        if (current != null) {
            System.out.println(current.getKeys());
        }


        System.out.println("-----------------------------------");

        BTNode current1 = bTree.searchBT(bTree.getRoot(), 0, null, null);

        System.out.println(current1.getKeys());

        System.out.println("-------------测试分裂--------------------");
        System.out.println("----------------未分裂结构-----------------------");
        System.out.println(bTree.getRoot());
        System.out.println("----------------分裂后结构-----------------------");
        bTree.spiltBT(bTree.getRoot(), 0);
        System.out.println(bTree.getRoot());


    }

    @Test
    public void insertBT() {

        System.out.println("----------测试插入操作----------");
        BTree bTree = new BTree();
        int[] keys = {1, 2, 3, 10, 15, 15,4, 5, 16, 19, 6, 7, 32, 35, 20,20, 21, 25, 30, 40};


        for (int key:keys
             ) {
            bTree.setRoot(bTree.insertBT(bTree.getRoot(), key));
        }

        bTree.inOrderTraverse(bTree.getRoot());
    }
}