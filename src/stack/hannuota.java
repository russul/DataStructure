package stack;
import java.io.*;

public class hannuota {
	public static void main(String[] args) throws IOException{
		int j;
		String str;
		BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入盘子数量");
		
			str = keyin.readLine();
		
		j = Integer.parseInt(str);
		hano(j,1,2,3);
		
		
		
		
		
		
		
		
	} 
	public static void hano(int n, int p1,int p2,int p3){
		if(n==1){
			System.out.println("盘子从" + p1 +"移到" +p3);  //递归调用结束标志
			}
		
			else{
				hano(n-1,p1,p3,p2);//将n-1个盘子从1移到2
				System.out.println("盘子从"+p1+"移到"+p3);  //将第n个盘子从1移到3
				hano(n-1,p2,p1,p3);//将n-1个盘子从2移到3
				
			}
		}
	
}
