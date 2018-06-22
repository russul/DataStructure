package queue;

public class CircleQueue {
	private int head;
	private int tail;
	private boolean flag = false;
	private Object[] objects;

	// 初始化队列
	public CircleQueue(int qLength) {
		objects = new Object[qLength];
		head = qLength - 1;
		tail = qLength - 1;
	}

	public boolean isEmpty() {
		if (!flag && head == tail) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (flag && head == tail) {
			return true;
		}
		return false;
	}

	public void enQueue(Object data) throws MyQueueException {
		if (isFull()) {
			throw new MyQueueException("队列上溢");
		}
		if (!flag) {
			objects[tail--] = data;
			if (tail < 0) {
				tail = tail + objects.length;
				flag = true;
			}
		} else {
			objects[tail--] = data;
		}

	}

	public Object deQueue() throws MyQueueException {
		if (isEmpty()) {
			throw new MyQueueException("队列下溢");
		}
		Object data = null;
		if (flag) {
			data = objects[head];
			head--;
			if (head < 0) {
				head = head + objects.length;
				flag = false;
			} 
		}else {
				data = objects[head];
				head--;
			}

		return data;
	}
}
