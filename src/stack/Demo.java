package stack;

public class Demo {
	public static void main(String[] args) throws MyStackException {
		StackByArray stack=new StackByArray(10);
		System.out.println(stack.isEmpty());
		stack.push(new Integer(1));
		stack.push("day");
		stack.push('c');
		stack.push(new Float(77.89));
		System.out.println("--------------------------------------");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
		System.out.println("-------------------------------------------------");
		StackByLinkedList s=new StackByLinkedList();
		System.out.println(s.isEmpty());
		Node n1=new Node();
		Node n2=new Node();
		Node n3=new Node();
		n1.setData(10);
		n1.setNext(null);
		n2.setData("haha");
		n2.setNext(null);
		n3.setData('s');
		n3.setNext(null);
		
		s.push(n1);
		s.push(n2);
		s.push(n3);
		while (!s.isEmpty()) {
			System.out.println(s.pop().getData());
			
		}
	}
}
