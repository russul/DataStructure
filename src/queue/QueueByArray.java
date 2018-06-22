package queue;

public class QueueByArray {
	private int head;
	private int tail;

	private Object[] objects;

	// 初始化队列
	public QueueByArray(int qLength) {
		objects = new Object[qLength];
		head = qLength - 1;
		tail = qLength - 1;
	}

	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		if(tail==-1){
			return true;
		}
		return false;
	}

	public void enQueue(Object data) throws MyQueueException {
		if (tail == -1) {
			throw new MyQueueException("队列上溢");
		}
		objects[tail--] = data;
	}

	public Object deQueue() throws MyQueueException {
		if (isEmpty()) {
			throw new MyQueueException("队列下溢");
		}

		Object data = objects[head];
		head--;
		return data;
	}
}
