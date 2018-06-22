package linkedlist;

import list.Node;

public class Demo {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		System.out.println(l1.isEmpty());
		// 头插法
		l1.insertHead(new Node(5, null));
		l1.insertHead(new Node(6, null));
		l1.insertHead(new Node(7, null));
		System.out.println(l1.isEmpty());
		System.out.println(l1.toString());
		System.out.println("-----------------------------");
		LinkedList l2 = new LinkedList();
		System.out.println(l2.isEmpty());
		System.out.println(l2.length());
		// 尾插法
		l2.insertTail(new Node(10, null));
		l2.insertTail(new Node(20, null));
		l2.insertTail(new Node(30, null));
		l2.insertTail(new Node(40, null));
		System.out.println(l2.length());
		System.out.println(l2.isEmpty());
		System.out.println(l2.toString());
		System.out.println("--------------------------------------------");
		LinkedList l3 = new LinkedList();
		l3.insertHead(new Node(100, null));
		// 头插法(表是非空时才能使用)
		l3.insertNodeByLoc(1, new Node(200, null));
		l3.insertNodeByLoc(1, new Node(300, null));
		l3.insertNodeByLoc(2, new Node(4000, null));
		System.out.println(l3.length());
		System.out.println(l3);
		System.out
				.println("---------------------带头节点的链表操作-------------------------");
		HLinkedList hl1 = new HLinkedList();
		System.out.println(hl1.isEmpty());
		hl1.insertByLocPre(1, new Node(10, null));
		hl1.insertByLocPre(1, new Node(20, null));
		hl1.insertByLocPre(1, new Node(30, null));
		hl1.insertByLocPre(1, new Node(400, null));
		hl1.insertByLocPre(2, new Node("ac", null));
		hl1.insertByLocPre(3, new Node("abc", null));
		hl1.insertByLocPre(1, new Node(50, null));
//		System.out.println(hl1.length());
//		System.out.println(hl1.toString());
//		System.out.println(hl1.indexOf(20));
//		hl1.delete(3);
		System.out.println(hl1.length());
		System.out.println(hl1.toString());
		System.out.println(hl1.indexOf(20));
		System.out.println(hl1.indexOf(400));
		System.out.println(hl1.indexOf("abc"));
		

	}
}
