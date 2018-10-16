package tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/16
 */
public class BiTreeTest {

    @Test
    public void initTree() {
    }

    @Test
    public void destroyTree() {
    }

    @Test
    public void createTree() {
    }

    @Test
    public void clearTree() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void treeDepth() {
    }

    @Test
    public void root() {
    }

    @Test
    public void value() {
    }

    @Test
    public void assign() {
    }

    @Test
    public void leftChild() {
    }

    @Test
    public void rightSibling() {
    }

    @Test
    public void insertChild() {
    }

    @Test
    public void deleteChild() {
    }

    @Test
    public void preOrderTraverse() {
    }

    @Test
    public void preOrderTraverse1() {
    }

    @Test
    public void inOrderTraverse() {
    }

    @Test
    public void postOrderTraverse() {
        String s = "j,l,g";
        String[] strings = s.split(",");
        for (String s1 : strings) {
            System.out.println(s1);
        }
    }

    @Test
    public void createBiTreePre() {
        String[] data = {"A", "B", "#", "D", "#", "#", "C", "#", "#"};
        System.out.println("--------先（前）序输入构造二叉树的扩展二叉树的前序遍历序列-----------");
        for (String s : data
                ) {
            System.out.println(s);
        }
        System.out.println("--------先（前）序输入构造二叉树-----------");
        BiTree biTree = new BiTree(data);
        System.out.println("--------先（前）序输入构造二叉树的前序遍历-----------");
        biTree.preOrderTraverse();
        System.out.println("--------先（前）序输入构造二叉树的中序遍历-----------");
        biTree.inOrderTraverse();
        System.out.println("--------先（前）序输入构造二叉树的后序遍历-----------");
        biTree.postOrderTraverse((BiTNode) biTree.root());

        System.out.println("--------后序输入构造二叉树的扩展二叉树的后序遍历序列-----------");
        String treeData = "#,#,#,D,B,#,#,C,A";
        String[] dataArray = treeData.split(",");
        for (String s:dataArray
             ) {
            System.out.println(s);
        }
        System.out.println("------后序输入构造二叉树-------");
        BiTree biTree1 = new BiTree(treeData);
        System.out.println("--------后序输入构造二叉树的前序遍历-----------");
        biTree1.preOrderTraverse();
        System.out.println("--------后序输入构造二叉树的中序遍历-----------");
        biTree1.inOrderTraverse((BiTNode) biTree1.root());
        System.out.println("--------后序输入构造二叉树的后序遍历-----------");
        biTree1.postOrderTraverse((BiTNode) biTree1.root());
    }
}