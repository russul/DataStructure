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

    public static A change3(A a) {
        a = new A();
        System.out.println("形参:" + a);
        return a;
    }

    public static void add(byte b){
        b = b++;
    }

    public static byte add2(byte b){
        System.out.println("前："+b);

//        b = b++;
        b++;
        System.out.println("后："+b);
        return b;
    }



    public static void fun1(String s,int i){}
    private static void fun1(int i, String s){}



}
