package linkedlist;

import list.Node;

public class LinkedList {
	private Node head = null;

	public boolean isEmpty() {
		return head == null;
	}

	public int length() {
		int length = 0;
		Node p = head;
		while (p != null) {

			length++;
			p = p.getNext();
		}
		return length;
	}

	public void insertHead(Node n) {
		n.setNext(head);
		head = n;
	}

	public void insertTail(Node n) {
		if (isEmpty()) {
			n.setNext(head);
			head = n;
		} else {
			Node p = head;
			while (p.getNext() != null) {
				p = p.getNext();
			}
			n.setNext(p.getNext());
			p.setNext(n);
		}

	}

	// 在某个位置之前插入新节点，location=1，就是头插法.
	// 如果想实现尾插，在单链表中就要在location后插入新节点
	public void insertNodeByLoc(int loction, Node node) {
		if (loction < 1 || loction > length()) {
			System.out.println("非法插入");
			return;
		}
		Node p = head; // 光标指针
		int loc = 1;// 光标位置
		// 不带头结点的链表，在表头插入和在中间结尾插入代码不同，而在带头结点的链表中是一致的
		if (loction == 1) {
			node.setNext(head);
			head = node;
			return;
		}
		// 将光标移动到location的前一个
		while (loc < loction - 1) {
			p = p.getNext();
			loc++;
		}

		node.setNext(p.getNext());
		p.setNext(node);
	}

	@Override
	public String toString() {
		Node p = head;
		String string = "[";
		while (p != null) {
			string = string + p.getData().toString() + ",";
			p = p.getNext();
		}

		string = string.substring(0, string.length() - 1) + "]";
		return string;
	}

}
