package string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/10
 */
public class LinkedStringTest {

    private IString iString;

    @Before
    public void setUp(){
        iString = new LinkedString();

    }

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
        char[] chars1 = {'d', 'c', 'e', 'f', 'g'};
        char[] chars = {'e', 'y'};
        char[] chars2 ={'s','f','t'};
        char[] chars3 ={'w','b','q','b','q'};
        char[] chars4={'a','s','c','w'};
        char[] chars5={'g','h','1','1'};
        char[] chars6={'1','2','y','7','0'};
        char[] chars7={'0','8','7','7','7'};
        char[] chars8={'0','0','h','e'};
        Chunk chunk = new Chunk(chars);
        Chunk chunk1 =new Chunk(chars1);
        Chunk chunk2 =new Chunk(chars2);
        Chunk chunk3 =new Chunk(chars3);
        Chunk chunk4 =new Chunk(chars4);
        Chunk chunk5 =new Chunk(chars5);
        Chunk chunk6 =new Chunk(chars6);
        Chunk chunk7 =new Chunk(chars7);
        Chunk chunk8 =new Chunk(chars8);
        ((LinkedString)iString).insertTail(chunk);
        ((LinkedString)iString).insertTail(chunk1);
        ((LinkedString)iString).insertTail(chunk2);
        ((LinkedString)iString).insertTail(chunk3);
        System.out.println(iString.toString());




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
        //插入节点必须是新的节点，不能是链串中存在的节点，
        // 不然的话会构成循环（这样就不是单向的了），会导致单向链的一些方法无法正常使用
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