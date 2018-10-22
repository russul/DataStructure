package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/22
 */
public class BiThrTreeTest {

    private BiThrTree biThrTree;

    @Before
    public void setUp() {

        String[] data = {"A", "B", "D", "H", "#", "#", "I", "#", "#", "E", "J", "#", "#", "#", "C", "F", "#", "#", "G", "#", "#"};
        System.out.println("--------先（前）序输入构造二叉树的扩展二叉树的前序遍历序列-----------");
        for (String s : data
                ) {
            System.out.println(s);
        }
        biThrTree = new BiThrTree(data);
        System.out.println("--------线索二叉树创建完成-----------");
    }

    @Test
    public void inThreading() {
    }

    @Test
    public void createBiThrTreePre() {
    }

    @Test
    public void findFirst() {
    }

    @Test
    public void findLastWithHead() {

        System.out.println("---------------测试获取最后一个结点方法--------------");
        BiThrNode last = biThrTree.findLastWithHead();
        System.out.println("---------------最后一个结点的信息--------------");
        System.out.println("---------------最后一个结点的数据--------------");
        System.out.println(last.getData());
        System.out.println("---------------最后一个结点的lTag--------------");
        System.out.println(last.getlTag());
        System.out.println("---------------最后一个结点的rTag--------------");
        System.out.println(last.getlTag());

    }


    @Test
    public void getRoot() {
    }

    @Test
    public void setRoot() {
    }

    @Test
    public void inOrderTraverse_Thr() {
        System.out.println("-----------遍历线索二叉树的内容------------");
        biThrTree.inOrderTraverse_Thr();
    }

    @Test
    public void inOrderTraverse_Thr_Reverse() {
        System.out.println("-----------逆向遍历线索二叉树的内容1------------");
        biThrTree.inOrderTraverse_Thr_Reverse();
        System.out.println("-----------逆向遍历线索二叉树的内容2------------");
        biThrTree.inOrderTraverse_Thr_Reverse_2();
    }

    @Test
    public void createBiThrTree() {
        System.out.println("--------------------创建不带有头结点的线索二叉树------------------------");
        BiThrTree biThrTree1= new BiThrTree();
        String[] treeData = {"A", "B", "D", "H", "#", "#", "I", "#", "#", "E", "J", "#", "#", "#", "C", "F", "#", "#", "G", "#", "#"};
        biThrTree1.createBiThrTree(treeData);
        BiThrNode first = biThrTree1.findFirst();
        System.out.println("---------------第一个结点的数据--------------");
        System.out.println(first.getData());
        System.out.println("---------------第一个结点的lTag--------------");
        System.out.println(first.getlTag());
        System.out.println("---------------第一个结点的rTag--------------");
        System.out.println(first.getlTag());

        System.out.println("---------------遍历--------------");
        biThrTree1.inOrderTraverse_Thr_No_Head();

        System.out.println("---------------逆向遍历--------------");
        biThrTree1.inOrderTraverse_Thr_No_Head_Reverse();
    }
}