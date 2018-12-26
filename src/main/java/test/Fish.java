package test;

/**
 * @author: create by kevinYang
 * @version: v1.0
 * @description: test
 * @date:2018/11/22 0022
 */
public class Fish extends Animal{
    public static int x2 = produce();

    private static int produce() {
        System.out.println("子类的静态变量初始化了");
        return 0;
    }

    static{
        System.out.println("子类的静态代码块执行了");
    }

    {
        System.out.println("子类的构造块执行了");
    }

    public B b= new B();

    public Fish() {

        System.out.println("子类的构造方法执行了");
    }
}
