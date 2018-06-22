package queue;

import list.*;

public class QueueByLinkedList {
	private Node head;
	private Node tail;

	public QueueByLinkedList() {
		head = new Node();
		head.setNext(null);
		tail = head;                                                                                                                                                                                                                                   
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public void enQueue(Node n) {
		n.setNext(null);
		tail.setNext(n);
		tail = n;
	}

	public Node deQueue() throws MyQueueException {
		if (isEmpty()) {
			throw new MyQueueException("队列下溢");
		}
		Node node = head.getNext();
		head.setNext(head.getNext().getNext());
		if (node == tail) {
			tail = head;
		}
		return node;
	}
}
