package test;

public class Test {
	public static void main(String[] args) {
		syso(10);
		show(1);
	}
	
	public static void syso(int a){
		if(a>3){
			System.out.println("这是一个大于3的数");
		}
		if(a>5){
			System.out.println("这是一个大于5的数");
		}
	}
	public static void show(int i){
		int j=0;
		while(j<5){
			System.out.println(i);
			++j;
		}
	}
}
