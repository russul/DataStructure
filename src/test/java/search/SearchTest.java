package search;

import org.junit.Test;
import tree.BiTree;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: search
 * @date:2018/10/30
 */
public class SearchTest {

    @Test
    public void sequential_Search() {
    }

    @Test
    public void binary_Search() {
        int[] collection = {1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int key = 62;
        int out = Search.binary_Search(collection, key);
        System.out.println(out);
    }

    @Test
    public void interpolation_Search() {
        int[] collection = {1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int key = 62;
        int out = Search.interpolation_Search(collection, key);
        System.out.println(out);
    }

    @Test
    public void fibonacciSearch() {
        int[] collection = {1, 16, 24, 35, 47, 59, 62, 73, 88, 99};
        int key = 59;
        int out = Search.fibonacciSearch(collection, key);
        System.out.println(out);
        int out2 = Search.fibonacci_Search(collection, key);
        System.out.println(out2);
    }

    @Test
    public void BSTSearch() {
        BiSortTree biSortTree = new BiSortTree();           /*先建立一棵空的二叉排序树*/
        int[] collection = {62, 88, 58, 47, 35, 73, 51, 99, 37, 93, 29, 36, 49, 48, 50, 56};
        for (int c : collection
                ) {
            biSortTree.setRoot(Search.insertBST(biSortTree.getRoot(), c));
        }
        System.out.println(Search.current.getData());

        System.out.println(Search.searchBST(biSortTree.getRoot(), 73, null));
        System.out.println(Search.current.getData());


        System.out.println("-------------------------------------");
        BiSortTree biSortTree1 = new BiSortTree();
        for (int c : collection
                ) {
            biSortTree1.setRoot(Search.insertBST2(biSortTree1.getRoot(), c));
        }
        BiTNode p = null;
        BiTNode current = Search.searchBST(biSortTree1.getRoot(), 99, null, p);
        System.out.println(current.getData());
        System.out.println("----------------------------------------");
        BiSortTree biSortTree2 = new BiSortTree();
        for (int c : collection
                ) {
            biSortTree2.setRoot(Search.insertBST2(biSortTree2.getRoot(), c));
        }

        biSortTree2.inOrderTraverse(biSortTree2.getRoot());
        biSortTree2.deleteBST(biSortTree2.getRoot(), 51);

        System.out.println("--------删除后遍历1--------");
        biSortTree2.inOrderTraverse(biSortTree2.getRoot());
//        biSortTree2.deleteBST(biSortTree2.getRoot(), 47);
//
//        System.out.println("--------删除后遍历2--------");
//        biSortTree2.inOrderTraverse(biSortTree2.getRoot());
//
//        biSortTree2.deleteBST(biSortTree2.getRoot(), 62);
//
//        System.out.println("--------删除后遍历3--------");
//        biSortTree2.inOrderTraverse(biSortTree2.getRoot());
    }


}