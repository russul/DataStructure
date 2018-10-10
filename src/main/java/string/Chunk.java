package string;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/8 串的块链节点
 */
public class Chunk {


    //定义一个节点中存储5个字符
    private char[] str = new char[5];
    private Chunk next;
    //为了方便串的长度计算
    private int length;


    public Chunk() {

    }

    public Chunk(char[] str) {

        this.setStr(str);
        this.setLength(str.length);
    }


    public Chunk(char[] str, Chunk chunk) {
        this.setStr(str);
        this.setLength(str.length);
        this.setNext(chunk);
    }

    public char[] getStr() {
        return str;
    }

    public void setStr(char[] str) {
        if (str == null) {
            this.str = null;
        }
        if (str.length > 5) {
            throw new RuntimeException();
        }
        for (int i = 0; i < str.length; i++) {
            this.str[i] = str[i];
        }

    }

    public Chunk getNext() {
        return next;
    }

    public void setNext(Chunk next) {
        this.next = next;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
