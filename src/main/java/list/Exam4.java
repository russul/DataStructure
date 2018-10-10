package list;
/*
 * 双向链表和单向链表的删除算法有一定区别
 * 单向链表必须让指针走到待删除节点的前一个，而双向链表由于既有前驱又有后继，可以让指针走到待删除节点处
 * 具体见下面的数三退一算法分别用两者实现
 * 如果用不带头结点的链表则不要考虑这些，会很简单，这里用了带头结点的链表，就要考虑头结点涉及到的问题
 */

public class Exam4 {
	public static void main(String[] args){
		
		//双向链表实现
		DuLinkedList l = new DuLinkedList();
		
		for(int j=1;j<=500;j++){
			l.insert(l.length(), j);
		}
		
	
		
		DuNode p = l.head.getNext();
		int count = 0;
		while(l.length()!=1){
			if(p.getData()!=null){
				p = p.getNext();
				count++;
			}else{
				p = p.getNext();
			}
			while(count == 2 && p!=l.head){
				
				
				p.getPrior().setNext(p.getNext());
				p.getNext().setPrior(p.getPrior());
				p = p.getNext();//让p指向被删除的节点的下一个，重新计数
				count = 0;
			}
		}
		
		System.out.println("双向链表实现数三退一："+p.getData());
		
		
		//单向链表实现

		DLinkedlist ll = new DLinkedlist();
		for(int j=1;j<=500;j++){
			ll.insert(ll.length(), j);
		}
		
		//ll.display();
		
		Node pp = ll.head.getNext();
	
		
		int icount = 0;
		while(ll.length()!=1){
			if(pp.getData()!=null){
				pp = pp.getNext();
				icount++;
			}else{
				pp = pp.getNext();
			}
			while(icount == 1 ){
				//较之双向链表，单向链表的情况要复杂些，要讨论最后节点与头结点的关系，有三种情况，如果用不带头结点的链表则不要考虑这些，会很简单
				if(pp == ll.head ||pp.getNext()==ll.head){
					
					pp = pp.getNext();
					pp.setNext(pp.getNext().getNext());
					pp = pp.getNext();
					icount = 0;
				}
				 else{
					
					 pp.setNext(pp.getNext().getNext());
					 pp = pp.getNext();
					 icount = 0;
				}
			}
		}
		
		System.out.println("单向链表实现数三退一："+pp.getData());
	}
}
