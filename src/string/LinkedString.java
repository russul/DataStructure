package string;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/8
 */
public class LinkedString implements IString {

    //带有头结点（头结点不存储数据）
    private Node head;

    public LinkedString() {
        head = new Node();
    }

    @Override
    public IString strCopy() {
        return null;
    }

    @Override
    public void clearStr() {



    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    @Override
    public int length() {
        Node node = head;
        int length = 0;
        if (head.getNote() != null) {
            length++;
        }
        return length;
    }

    @Override
    public int compare(IString t) {
        return 0;
    }

    @Override
    public IString concat(IString s) {
        return null;
    }

    @Override
    public IString subString(int pos, int len) {
        return null;
    }

    @Override
    public int index(IString subStr, int pos) {
        return 0;
    }

    @Override
    public IString strInsert(IString s1, int pos) {
        return null;
    }

    @Override
    public IString strDelete(int pos, int len) {
        return null;
    }

    @Override
    public char get(int i) {
        return 0;
    }
}
