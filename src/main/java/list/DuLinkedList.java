package list;
import java.util.Scanner;

public class DuLinkedList implements IList{

	public DuNode head;
	
	public DuLinkedList() {
		head = new DuNode();
		head.setPrior(head);
		head.setNext(head);   //初始化双向循环链表
	}
	
	

	public DuLinkedList(int n) {    
		
//		this();
//		Scanner sc = new Scanner(System.in);
//		for(int i = 0; i<n; i++){
//			insert(0,sc.next());
//		}
		this();
		for(int i = 0; i<n;i++){
			insert(length(),i+1);
		}
	}



	@Override
	public void remove(DuNode s) {
		// TODO Auto-generated method stub
		
	}



	public void clear() {
		head.setPrior(null);
		head.setNext(null);
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		DuNode p = head.getNext();
		int length = 0;
		while(p!=head){
			p = p.getNext();
			++length;
		}
		return length;
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public void insert(int i, Object x) {      //插入在Node i 前，如果i=length();就插在head前即表尾
		DuNode p = head.getNext();
		int j = 0;
		while(!p.equals(head)&&j<i){
			p = p.getNext();
			++j;
		}
		if(p.equals(head)&&j!=i){
			System.out.println("illegal insert!");
			
		}
		DuNode s = new DuNode(x);
		p.getPrior().setNext(s);
		s.setPrior(p.getPrior());
		s.setNext(p);
		p.setPrior(s);
		
	}

	@Override
	public void remove(int i) {
		DuNode p = head.getNext();
		int j = 0;
		while(!p.equals(head)&&j<i){
			p = p.getNext();
			++j;
		}
		if(j!=i){
			System.out.println("illegal remove!");
			
		}
		p.getPrior().setNext(p.getNext());
		p.getNext().setPrior(p.getPrior());
		
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void display() {
		
		DuNode p = head.getNext();
		while(p!=head){
			
			System.out.println(p.data);
			p = p.getNext();
		}
		
		
	}

}
