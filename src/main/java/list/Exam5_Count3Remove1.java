package list;

public class Exam5_Count3Remove1 {
	public static void main(String[] args){
		DuLinkedList D = new DuLinkedList(200);
		DuNode p = D.head;
		
		D.display();

		while(D.length()!=1){
			
			for(int i=0;i<3;i++){
				p=p.getNext();
				if(p.getData()==null){ //为了避开头结点，因为头结点没有的数据，因此让指针P多走一步
					p = p.getNext();
				}	
			}
			if(p.getData()==null){ //为了避开头结点，因为头结点没有的数据，因此让指针P多走一步
				p = p.getNext();
			}	
			System.out.println("待删除点值："+ p.data);
			p.getPrior().setNext(p.getNext());
			p.getNext().setPrior(p.getPrior());
			System.out.println("D的当前长度:"+D.length());
		
			
			
			
		}
		System.out.print("最终值：");
		D.display();
		
		
	}
	
}
