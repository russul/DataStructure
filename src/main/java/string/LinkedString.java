package string;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: 带有头结点的单向链串
 * @date:2018/10/8
 */
public class LinkedString implements IString {

    //带有头结点（头结点不存储数据）
    private Chunk head;

    public LinkedString() {

        head = new Chunk();
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

//    @Override
//    public int length() {
//        Chunk chunk = head.getNext();
//        int length = 0;
//        while (chunk != null) {
//            if (chunk.getNext() != null) {
//                length += 5;
//
//            } else {
//                for (char c : chunk.getStr()
//                        ) {
//                    //规定#为非串字符
//                    if (c != '#') {
//                        length++;
//                    }
//                }
//            }
//            chunk = chunk.getNext();
//        }
//        return length;
//    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/10 17:01
     * @param []
     * @return int
     * @description 返回字符串的长度
     */
    @Override
    public int length() {
        Chunk chunk = head.getNext();
        int length = 0;
        while (chunk != null) {
            length += chunk.getLength();
            chunk = chunk.getNext();
        }
        return length;
    }

    public int chunkLength() {
        Chunk chunk = head.getNext();
        int length = 0;
        while (chunk != null) {
            length++;
            chunk = chunk.getNext();
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

    public void insertHead(Chunk chunk) {
        chunk.setNext(head.getNext());
        head.setNext(chunk);

    }

    public void insertTail(Chunk chunk) {
        Chunk chunk1 = head;
        while (chunk1.getNext() != null) {
            chunk1 = chunk1.getNext();
        }

        chunk.setNext(chunk1.getNext());

        chunk1.setNext(chunk);


    }


    @Override
    public String toString() {
        String s = "";
        Chunk chunk = head.getNext();
        while (chunk != null) {
            for (int i = 0; i < chunk.getLength(); i++) {
                s = s.concat(String.valueOf(chunk.getStr()[i]));
//                s = s + String.valueOf(chunk.getStr()[i]);
            }
            chunk = chunk.getNext();
        }
        return s;
    }
}
