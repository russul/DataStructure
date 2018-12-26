package test;



/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: test
 * @date:2018/11/22 0022
 */
public class Animal {

    static {
        System.out.println("父类的静态代码块执行了");
    }

    {
        System.out.println("父类的构造块执行了");
    }
    public Animal() {
        System.out.println("父类的构成方法执行了");
    }
    public static  int x1 = produce();

    private static int produce() {
        System.out.println("父类的静态变量执行了");
        return 0;
    }
    public A a = new A();

}
