package linkedlist;

import list.DuNode;
import list.Node;

public class DouLinkedList {
	private DuNode head;

	// 初始化带头节点的双向链表
	public DouLinkedList() {
		head = new DuNode();
	}

	public boolean isEmpty() {
		return head.getNext() == null && head.getPrior() == null;
	}

	public int length() {
		DuNode p = head.getNext();
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

	public void insertHead(DuNode d) {
		if (isEmpty()) {

			d.setNext(head.getNext());
			
			d.setPrior(head);
			head.setNext(d);
			return;
		}

		d.setNext(head.getNext());
		
		d.setPrior(head);
		head.getNext().setPrior(d);
		head.setNext(d);

	}

	public void insertByLocPre(int location, DuNode d) {
		if (location < 1 || location > length()) {
			System.out.println("非法插入");
			return;
		}
		DuNode p = head;
		int loc = 0;
		while (loc < location) {
			p = p.getNext();
			loc++;
		}
		p.getPrior().setNext(d);
		d.setPrior(p.getPrior());
		d.setNext(p);
		p.setPrior(d);
	}

	public void delete(int location) {
		if (isEmpty()) {
			System.out.println("空表禁止删除");
			return;
		}
		DuNode p = head;
		
		int loc = 0;
		
		while (loc < location) {
			p = p.getNext();
			loc++;
			if(loc==location){
				p.getPrior().setNext(p.getNext());
				return;
			}
			
		}
		
		p.getPrior().setNext(p.getNext());
		p.getNext().setPrior(p.getPrior());

	}

	public int indexOf(Object data) {
		return 0;
	}

	public String toString() {
		DuNode p = head.getNext();
		String string = "[";
		while (p != null) {
			string = string + p.getData().toString() + ",";
			p = p.getNext();
		}

		string = string.substring(0, string.length() - 1) + "]";
		return string;
	}
}
