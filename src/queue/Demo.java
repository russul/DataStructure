package queue;
/**
 * @author Lenovo
 * 2018.6.17
 * 
 */
import list.Node;

public class Demo {
	public static void main(String[] args) throws MyQueueException {
		QueueByArray q1 = new QueueByArray(4);
		System.out.println(q1.isEmpty());
		System.out.println(q1.isFull());
		q1.enQueue(10);
		q1.enQueue("队列");
		q1.enQueue('q');
		q1.enQueue(88.889);
		System.out.println(q1.isEmpty());
		System.out.println(q1.isFull());
		// while (!q1.isEmpty()) {
		// System.out.println(q1.deQueue());
		// System.out.println(q1.isEmpty());
		// }

		for (int i = 0; i < 2; i++) {
			System.out.println(q1.deQueue());
		}

		System.out.println("q1满了吗:" + q1.isFull());
		Object o1 = null;
		Object o2 = null;
		System.out.println(o1 == o2);
		System.out
				.println("---------------------------------------------------");
		QueueByLinkedList q2 = new QueueByLinkedList();
		System.out.println(q2.isEmpty());
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		n1.setData("这是链表实现的队列");
		n2.setData('l');
		n3.setData(100);
		q2.enQueue(n1);
		q2.enQueue(n2);
		q2.enQueue(n3);
		while (!q2.isEmpty()) {
			System.out.println(q2.deQueue().getData());
			System.out.println(q2.isEmpty());

		}
		System.out.println("-----------循环队列-----------");
		CircleQueue cQueue = new CircleQueue(3);
		System.out.println(cQueue.isEmpty());
		System.out.println(cQueue.isFull());
		cQueue.enQueue("no.1");
		cQueue.enQueue("no.2");
		cQueue.enQueue("no.3");
		System.out.println(cQueue.isEmpty());
		System.out.println(cQueue.isFull());
//		while (!cQueue.isEmpty()) {
//			System.out.println(cQueue.deQueue());
//		}
		for (int i = 0; i < 2; i++) {
			System.out.println(cQueue.deQueue());
		}

		System.out.println("cq满了吗:" + cQueue.isFull());
		System.out.println("----------------------------------------------");
		cQueue.enQueue("no.4");
		cQueue.enQueue("no.5");
		while (!cQueue.isEmpty()) {
			System.out.println(cQueue.deQueue());
		}
	}
}
