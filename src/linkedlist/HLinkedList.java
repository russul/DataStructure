package linkedlist;

import list.Node;

public class HLinkedList {
	private Node head;

	public HLinkedList() {
		head = new Node(null, null);
	}

	public boolean isEmpty() {
		return head.getNext() == null;
	}

	public int length() {
		Node p = head.getNext();
		int length = 0;
		if (p == null) {
			return length;
		}
		while (p != null) {
			length++;
			p = p.getNext();
		}
		return length;
	}

	public void insertHead(Node n) {
		n.setNext(head.getNext());
		head.setNext(n);
	}

	public void insertTail(Node n) {
		if (isEmpty()) {
			n.setNext(head.getNext());
			head.setNext(n);
			return;
		}
		Node p = head;
		while (p.getNext() != null) {
			p = p.getNext();
		}
		n.setNext(p.getNext());
		p.setNext(n);
	}

	public void insertByLocPre(int loction, Node n) {
		Node p = head;
		int loc = 0;
		while (loc < loction - 1) {
			p = p.getNext();
			loc++;
		}
		n.setNext(p.getNext());
		p.setNext(n);
	}

	public void delete(int loction) {
		Node p = head;
		int loc = 0;
		while (loc < loction - 1) {
			p = p.getNext();
			loc++;
		}

		p.setNext(p.getNext().getNext());

	}

	public int indexOf(Object data) {
		if (isEmpty()) {
			System.out.println("空表无法查询数据");
			return -1;
		}
		Node p = head.getNext();
		int index = 0;
		while (p != null) {
			//值比较用equals(),data虽然声明为Object，但在具体执行时，调用具体子类的重写方法（动态绑定、多态）
			if (p.getData().equals(data)) {

				break;

			}
			p = p.getNext();
			index++;
		}
		if (index == length()) {
			System.out.println("表中不存在此数据");
			return -2;
		}
		return index;
	}

	public String toString() {
		Node p = head.getNext();
		String string = "[";
		while (p != null) {
			string = string + p.getData().toString() + ",";
			p = p.getNext();
		}

		string = string.substring(0, string.length() - 1) + "]";
		return string;
	}
}
