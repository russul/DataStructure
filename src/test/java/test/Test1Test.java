package test;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

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
        System.out.println("方法执行前的实参：" + a);
        System.out.println(a.name);
        Test1.change2(a);
        System.out.println("方法执行后的实参：" + a);
        System.out.println(a.name);

        System.out.println("方法执行前的实参：" + a);

        a = Test1.change3(a);
        System.out.println("方法执行后的实参：" + a);


        byte b = 127;

        Test1.add(b);
        System.out.println(b);
        byte b1 = Test1.add2(b);
        System.out.println(b1);
        Test1.add(++b);
        System.out.println(b);
        byte b2 = Test1.add2(++b);
        System.out.println(b2);

        System.out.println(174%1000);

        Integer i1 = 120;
        Integer i2 = new Integer(120);
        int i3 = 120;

        System.out.println(i1==i2);
        System.out.println(i1==i3);

        Integer i4 = 128;
        Integer i7 = Integer.valueOf(128);
        Integer i5 = new Integer(128);
        Integer i8 = new Integer(130);

        int i6 = 128;
        System.out.println(i4==i7);
        System.out.println(i4==i5);
        System.out.println(i4==i6);
        System.out.println(i5==i6);
        System.out.println(i6==i5);
        System.out.println(i5<=i8);

        System.out.println(i5.equals(i7));

        B b3 = new B();
        B b4 = new B();

        System.out.println(b3);
        System.out.println(b4);






    }


    @Test
    public void test() throws Exception{
        Class clazz = Class.forName("test.B");
        B b5 = (B) clazz.newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m:methods
             ) {
            m.setAccessible(true);
            System.out.println(m.getName());
        }
    }
}