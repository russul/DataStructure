package tree;

import java.util.List;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: tree
 * @date:2018/10/23
 */
public class HuffmanTree {


    private HuffmanNode root;

    public HuffmanTree() {
    }

    public HuffmanTree(List<HuffmanNode> huffmanNodes) {
        createTree(huffmanNodes);
        this.root = huffmanNodes.get(0);
    }


    public void createTree(List<HuffmanNode> huffmanNodes) {
        int flag = 0;
        while (huffmanNodes.size() != 1) {

            /*将结点按照权值从小到大排序*/
            bubbleSort(huffmanNodes);
            //创建一个新结点
            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.setData("new node" + flag);
            /*给结点设置属性值*/
            huffmanNode.setLeftChild(huffmanNodes.get(0));
            huffmanNode.setRightChild(huffmanNodes.get(1));
            huffmanNode.setWeight(huffmanNodes.get(0).getWeight() + huffmanNodes.get(1).getWeight());
            //删除合并之前的两个结点（由于remove（index）方法删除后，后面的元素会自动向前移动，所以两次删除第一个元素即可）
            huffmanNodes.remove(0);
            huffmanNodes.remove(0);
            /*将新生成的结点加入结点集合*/
            huffmanNodes.add(0,huffmanNode);
            flag++;
        }

    }

    public void bubbleSort(int[] weights) {
        for (int j = weights.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (weights[i] > weights[i + 1]) {
                    int temp = weights[i];
                    weights[i] = weights[i + 1];
                    weights[i + 1] = temp;
                }
            }
        }

    }

    public void bubbleSort(List<HuffmanNode> huffmanNodes) {
        for (int j = huffmanNodes.size() - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (huffmanNodes.get(i).getWeight() > huffmanNodes.get(i + 1).getWeight()) {

                    /*List的add(int index,E element)在列表的指定位置插入指定元素（可选操作）。
                    将当前处于该位置的元素（如果有的话）和所有后续元素向右移动（在其索引中加 1）。 */
                    huffmanNodes.add(i, huffmanNodes.get(i + 1));
                    /*List的remove(int index)移除列表中指定位置的元素（可选操作）。
                    将所有的后续元素向左移动（将其索引减 1）。返回从列表中移除的元素。
                    所以这里删除i+2处的元素*/
                    huffmanNodes.remove(i+2);
                    /*这两行代码就可以完成元素位置的替换*/

                }
            }
        }

    }

    public void preOrderTraverse(HuffmanNode node) {

        if (node != null) {
            System.out.println(node.getData());
            preOrderTraverse(node.getLeftChild());
            preOrderTraverse(node.getRightChild());
        }

    }

    public HuffmanNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanNode root) {
        this.root = root;
    }
}
