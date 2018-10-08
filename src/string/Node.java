package string;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/8
 */
public class Node {
    //定义一个节点中存储5个字符
    private char[] str = new char[5];
    private Node note;


    Node(){

    }

    public char[] getStr() {
        return str;
    }

    public void setStr(char[] str) {
        this.str = str;
    }

    public Node getNote() {
        return note;
    }

    public void setNote(Node note) {
        this.note = note;
    }
}
