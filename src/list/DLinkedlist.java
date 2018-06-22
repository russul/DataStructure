package list;
import java.util.Scanner;
public class DLinkedlist implements IList{
	//定义头指针
	public Node head;

	
	public DLinkedlist() {
		head = new Node();         //初始化头结点
		head.setNext(head);
	}
	

	public DLinkedlist(int n, boolean Order) {
		this();     //调用本类的构造方法，初始化头结点，形成空表
		if(Order){
			create1(n);
		}else{
			create2(n);
		}
	}
	//尾插法
	public void create1(int n){
//		Scanner sc = new Scanner(System.in);
		
//		for(int i = 0;i<n;i++){
//			insert(length(),sc.next());
//		}
		for(int i = 0;i<n;i++){
			insert(length(),i+1);
		}
	}
	
	@Override
	public void remove(DuNode s) {
		// TODO Auto-generated method stub
		
	}


	//头插法
	public void create2(int n){
		Scanner sc = new Scanner(System.in);
		for(int i = 0;i<n;i++){
			insert(0,sc.next());
		}
	}

	public void clear() {
		head.setNext(head);
		System.out.println("empty linkedlist");
		
	}

	@Override
	public boolean isEmpty() {
		return (head.getNext() == head);
	}

	@Override
	public int length() {
		Node p = head.getNext();
		int length = 0;
		while(p!= head){
			p = p.getNext();
			++length;
		}
		return length;
	}

	@Override
	public Object get(int i) {
		
		return null;
	}

	//带头结点的插入有别于不带结点的插入
	public void insert(int i, Object x) {
		Node p = head;
		int j = -1;
		while(j<i-1){
			p = p.getNext();    //让头指针跑到第I个结点的前驱
			++j;
		}
		//i<0或者大于表长加一为非法插入
		if(j>i-1){
			System.out.println("illegal insert!");
		}
		Node s = new Node(x);//生成新结点
		//修改新节点的前驱与后继
			s.setNext(p.getNext());   //先改后继再改前驱
			p.setNext(s);
		
		
		
	}

	@Override
	public void remove(int i) {
		Node p = head;
		int j = -1;
		while(p.getNext()!= head&&j<i-1){
			p = p.getNext();    //让头指针跑到第I个结点的前驱
			++j;
		}
		if(p.getNext() == head||j>i-1){
			System.out.println("illegal remove!");
		}
		
		p.setNext(p.getNext().getNext());
		
	}

	@Override
	public int indexOf(Object x) {
		
		return 0;
	}

	@Override
	public void display() {
		
		Node p = head.getNext();
		while(p!= head){
			
			System.out.println(p.data);
			p = p.getNext();
		}
		
		
	}

}
