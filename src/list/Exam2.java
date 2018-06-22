package list;

public class Exam2 {
	public static void main(String[] args){
//		System.out.println("please enter 10 nodes!");
//		DLinkedlist l1 = new DLinkedlist(10,false);
//		l1.display();
//		
//		System.out.println("list is empty : " + l1.isEmpty() );
//		l1.remove(5);
//		//l1.clear();
//		l1.display();
//		System.out.println("list is empty : " + l1.isEmpty() );
		
		DLinkedlist l2=new DLinkedlist();
		System.out.println(l2.length());
		l2.insert(-1, 5);
		System.out.println(l2.isEmpty());
	}
}
