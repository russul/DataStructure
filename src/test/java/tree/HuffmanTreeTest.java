package tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/23
 */
public class HuffmanTreeTest {

    private HuffmanTree huffmanTree;

    @Before
    public void setUp() throws Exception {
        huffmanTree = new HuffmanTree();
    }

    @Test
    public void createTree() {
        List<HuffmanNode> huffmanNodes = new ArrayList<HuffmanNode>();
        HuffmanNode huffmanNode = new HuffmanNode("E",10);
        HuffmanNode huffmanNode1 = new HuffmanNode("D",30);
        HuffmanNode huffmanNode2 = new HuffmanNode("C",40);
        HuffmanNode huffmanNode3 =new HuffmanNode("B",15);
        HuffmanNode huffmanNode4=new HuffmanNode("A",5);
        huffmanNodes.add(huffmanNode);
        huffmanNodes.add(huffmanNode1);
        huffmanNodes.add(huffmanNode2);
        huffmanNodes.add(huffmanNode3);

        huffmanNodes.add(huffmanNode4);
        HuffmanTree huffmanTree1 = new HuffmanTree(huffmanNodes);
        huffmanTree1.preOrderTraverse(huffmanTree1.getRoot());

    }

}