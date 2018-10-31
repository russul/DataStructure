package test;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: test
 * @date:2018/10/31
 */
public class Test1 {

    public static void change(A a) {

        a = new A();
        System.out.println("形参:" + a);

    }

    public static void change2(A a) {
        a.name = "li";
        System.out.println("形参:" + a);
    }
}
