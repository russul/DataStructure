package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: B树的结点结构
 * @date:2018/11/2
 */
public class BTNode {

    private boolean leaf = true;
    private int n;  /*每个结点的元素个数（+1成该节点的度）*/
    private List<Integer> keys = new ArrayList<Integer>();
    private List<BTNode> children = new ArrayList<BTNode>();

    public BTNode() {
    }

    public BTNode(int n, int... keys) {

        this.n = n;
        for (int key : keys
                ) {
            this.getKeys().add(key);
        }


    }


    public boolean isLeaf() {
        return leaf;
    }

    /*通过children的长度判断是否是叶子*/
    public void setLeaf() {

        if (this.children.size() == 0) {
            this.leaf = true;
        } else {
            this.leaf = false;
        }
    }

    public void setLeaf(boolean leaf){
        this.leaf = leaf;
    }

    public List<Integer> getKeys() {
        return keys;
    }

    public void setKeys(List<Integer> keys) {
        this.keys = keys;
    }

    public List<BTNode> getChildren() {
        return children;
    }

    public void setChildren(List<BTNode> children) {
        this.children = children;
    }


    public int getN() {
        return n;
    }


    /*通过keys的长度给n赋值*/
    public void setN() {
        this.n = this.keys.size();
    }

    public void setN(int n){
        this.n = n;
    }
}
