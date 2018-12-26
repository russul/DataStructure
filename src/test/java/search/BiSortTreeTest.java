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
public class BiSortTreeTest {

    private BiSortTree biSortTree;


    @Before
    public void setUp() {

        biSortTree = new BiSortTree();
    }

    @Test
    public void searchBST() {

        int[] collection = new int[]{62, 88, 58, 47, 35, 73, 51, 99, 37, 93, 29, 36, 49, 48, 50, 56};
    }

    @Test
    public void insertBST2() {
        int[] collection = new int[]{62, 88, 58, 47, 35, 73, 51, 99, 37, 93, 29, 36, 49, 48, 50, 56};

        System.out.println(collection.length + ":" + collection[5]);

        for (int c : collection
                ) {
            biSortTree.setRoot(biSortTree.insertBST2(biSortTree.getRoot(), c));
        }

        biSortTree.inOrderTraverse(biSortTree.getRoot());

    }

    @Test
    public void delete() {
    }
}