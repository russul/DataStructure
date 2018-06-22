package list;
import java.util.Scanner;
//不带头结点的双向循环列表
public class DuLinkedListNoHead implements IList{

	public DuNode first;
	public DuNode last;
	
	public DuLinkedListNoHead(int n) {
		for(int i = 0;i < n;i++){
			insert();
		}
	
		  //初始化双向循环链表
	}
	
	

    @Override
	public void insert(int i, Object x) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		
	}



	public boolean isEmpty(){
    	return first == null;
    }


	public void clear() {
		first = null;
		last = null;
		
	}

	

	@Override
	public int length() {
		DuNode p = first;
		int length = 1;
		while(p!=last){
			p = p.getNext();
			++length;
		}
		return length;
	}

	@Override
	public Object get(int i) {
		DuNode p = first;
		for(int j = 0;j < i;j++){
			p = p.getNext();
		}
		
		return p.getData();
	}


	public void insert() {
		 DuNode s = new DuNode();
		
	
		if(this.isEmpty()){
			first = s;
			last = s;
			first.prior = last;
			last.next = first;
			
		}else{                           //将新节点插入链表尾部
			last.next = s;
			s.prior = last;
			s.next = first;
			first.prior = s;
			last = s;              //last = s;将新节点作为链表尾部节点
		
		}
		
	}

	@Override
	public void remove(DuNode s) {
		
		if(this.isEmpty()){
			System.out.println("LinkedList is Empty,No Remove!");
		}else{
			s.prior.next = s.next;
			s.next.prior = s.prior;
			if(s == first){
				first = s.next;
			}else if(s == last){
				last = s.prior;
			}
		}
		
		
	}

	@Override
	public int indexOf(Object x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void display() {
		
		DuNode p = first;
		
		for(int i=0;i<length();i++){
			System.out.println(p.data);
			p = p.getNext();
		
		}
		
	}

}
