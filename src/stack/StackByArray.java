package stack;

public class StackByArray {
	private Object[] objects;
	private int top;

	public StackByArray(int nLength) {
		objects = new Object[nLength];
		top = 0;

	}

	public boolean isEmpty() {
		return top == 0;
	}

	public void push(Object data) throws MyStackException {
		if (top == objects.length) {
			throw new MyStackException("栈已上溢");
		}
		objects[top] = data;
		top++;
	}

	public Object pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException("栈已下溢");
		}
		return objects[--top];
	}

	
}
