package test;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: test
 * @date:2018/10/31
 */
public class Test1Test {

    @Test
    public void change() {

        A a = new A();

        System.out.println(a);
        System.out.println(a.name);
        Test1.change(a);
        System.out.println(a);
        System.out.println(a.name);
        Test1.change2(a);
        System.out.println(a);
        System.out.println(a.name);
    }
}