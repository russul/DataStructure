package string;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/10
 */
public class LinkedStringTest {

    @org.junit.Test
    public void strCopy() {
    }

    @org.junit.Test
    public void clearStr() {
    }

    @org.junit.Test
    public void isEmpty() {
    }

    @org.junit.Test
    public void length() {
    }

    @org.junit.Test
    public void compare() {
    }

    @org.junit.Test
    public void concat() {
    }

    @org.junit.Test
    public void subString() {
    }

    @org.junit.Test
    public void index() {
    }

    @org.junit.Test
    public void strInsert() {
    }

    @org.junit.Test
    public void strDelete() {
    }

    @org.junit.Test
    public void get() {
    }

    @org.junit.Test
    public void insertHead() {

        char[] chars1 = {'d', 'c', 'e', 'f', 'g'};
        char[] chars = {'e', 'y'};
        IString iString4 = new LinkedString();

        LinkedString string = new LinkedString();
        System.out.println(iString4.length());
        Chunk chunk = new Chunk(chars1);
        Chunk chunk1 = new Chunk(chars, null);

        Chunk chunk2 =new Chunk(chars,null);
        ((LinkedString) iString4).insertHead(chunk);
        ((LinkedString) iString4).insertHead(chunk1);
        System.out.println(((LinkedString) iString4).toString());
        ((LinkedString) iString4).insertTail(chunk2);
        System.out.println(iString4.length());

//        string.insertHead(chunk);
//        System.out.println(string.length());
        System.out.println(((LinkedString) iString4).toString());
    }


}