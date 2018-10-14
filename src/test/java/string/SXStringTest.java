package string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: string
 * @date:2018/10/11
 */
public class SXStringTest {

    private SXString sxString;

    @Before
    public void setUp() throws Exception {
        char[] chars = {'1', '2', '2', '2', '3', 'w', 'j', 'q', '9', 'p', '0', '7',
                'g', '5', 'h', '4', 'b', 'a', '3', '7', 'h', 'g', 'c', '1', '1', '0', 'g', 'h', 'q', 'q'};
        sxString = new SXString(chars);
    }

    @Test
    public void strCopy() {
    }

    @Test
    public void clearStr() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void length() {
    }

    @Test
    public void compare() {
    }

    @Test
    public void concat() {
    }

    @Test
    public void subString() {
    }

    /*
     *
     *
     * @author kevin
     * @date 2018/10/11 14:10
     * @param []
     * @return void
     * @description 测试模式匹配算法（在串中找到子串出现的位置）
     */
    @Test
    public void index() {
        System.out.println("---------------串的内容-----------------");

        System.out.println(sxString);
        System.out.println("--------------借助其他串方法实现匹配------------------");


        System.out.println("--------------子串的内容-------------------");
        char[] chars = {'2', '2'};
        SXString sub = new SXString(chars);
        System.out.println(sub);

        System.out.println("---------------子串的位置索引（取值从0开始）--------------------");
        System.out.println(sxString.index(sub, 0));

        System.out.println("--------------朴素模式匹配算法--------------");
        System.out.println("---------------子串的位置（取值从1开始）--------------------");
        System.out.println(sxString.index_traditional(sub, 1));


        System.out.println("--------------子串的内容-------------------");
        char[] chars1 = {'2', '2', '3'};
        SXString sub1 = new SXString(chars1);
        System.out.println(sub1);
        System.out.println("---------------子串的位置索引（取值从0开始）--------------------");
        System.out.println(sxString.index(sub1, 0));

        System.out.println("---------------子串的位置（取值从1开始）--------------------");
        System.out.println(sxString.index_traditional(sub1, 1));

        System.out.println("---------------子串的next数组--------------------");


//        System.out.println(SXString.getNext(sub1));

        System.out.println("---------------KMP模式匹配算法--------------------");

        System.out.println(sxString.index_KMP(sub1,1));
        System.out.println("---------------KMP模式匹配算法改进--------------------");

        System.out.println(sxString.index_KMP_Val(sub1,1));

    }

    @Test
    public void strInsert() {
    }

    @Test
    public void strInsert2() {
    }

    @Test
    public void strDelete() {
    }

    @Test
    public void get() {
    }


}