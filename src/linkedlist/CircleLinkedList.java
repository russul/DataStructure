package linkedlist;

import list.DuNode;

public class CircleLinkedList {
	private DuNode head;

	public CircleLinkedList() {
		head = new DuNode();
		head.setNext(head);
		head.setPrior(head);
	}

	public boolean isEmpty() {
		return head.getNext() == head && head.getPrior() == head;
	}

	public int length() {
		DuNode p = head.getNext();
		int length = 0;
		while (p != head) {

			length++;
			p = p.getNext();
		}
		return length;
	}

	public void insertHead(DuNode d) {
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

		}

		p.getPrior().setNext(p.getNext());
		p.getNext().setPrior(p.getPrior());
	}

	public int indexOf(Object data) {
		if (isEmpty()) {
			return -1;
		}
		DuNode p = head.getNext();
		int index = 0;
		while (p.getNext() != head) {
			if (p.getData().equals(data)) {
				break;
			}
			p = p.getNext();
			index++;
		}
		if (index == length()) {
			return -2;
		}
		return index;
	}

	public String toString() {
		DuNode p = head.getNext();
		String string = "[";
		while (p != head) {
			string = string + p.getData().toString() + ",";
			p = p.getNext();
		}

		string = string.substring(0, string.length() - 1) + "]";
		return string;
	}
}
