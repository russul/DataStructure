package stack;

public class StackByLinkedList {
	private Node top = null;

	public boolean isEmpty() {
		return top == null;
	}

	public void push(Node n) {
		n.setNext(top);
		top = n;
	}

	public Node pop() throws MyStackException {
		if (this.isEmpty()) {
			throw new MyStackException("栈已下溢");
		}

		Node node = top;
		top = top.getNext();
		return node;
	}
	
}

class Node {
	private Object data;
	private Node next;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}