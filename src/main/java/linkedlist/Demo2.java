package linkedlist;

import list.DuNode;

public class Demo2 {
	public static void main(String[] args) {
		DouLinkedList dl = new DouLinkedList();
		System.out.println(dl.isEmpty());
		System.out.println(dl.length());
		dl.insertHead(new DuNode(10));
		System.out.println(dl.isEmpty());
		System.out.println(dl.length());
		dl.insertHead(new DuNode(20));
		System.out.println(dl.isEmpty());
		System.out.println(dl.length());

		dl.insertByLocPre(2, new DuNode(30));
		System.out.println(dl.length());
		System.out.println(dl);
		dl.delete(3);
		System.out.println(dl);
		System.out.println("------------循环链表测试-------------");
		CircleLinkedList cl = new CircleLinkedList();
		System.out.println(cl.isEmpty());
		System.out.println(cl.length());
		cl.insertHead(new DuNode(100));
		cl.insertHead(new DuNode(200));
		System.out.println(cl.isEmpty());
		System.out.println(cl.length());
		System.out.println(cl);
		cl.insertByLocPre(2, new DuNode(300));
		System.out.println(cl);
		System.out.println(cl.indexOf(100));
		System.out.println(cl.indexOf(300));
	}
}
