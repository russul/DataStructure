package list;

public class DuNode {
	public Object data;
	public DuNode prior;
	public DuNode next;
	
	public DuNode(){
		this(null);
	}
	
	public DuNode(Object data){
		this.data = data;
		this.prior = null;
		this.next = null;
//		
	}
	
	public Object getData(){
		return data;
		
	}
	
	public DuNode getPrior(){
		return prior;
		
	}
	
	public DuNode getNext(){
		return next;
		
	}
	
	public void setData(Object data){
		this.data = data;
	}
	public void setPrior(DuNode prior){
		this.prior = prior;
	}
	public void setNext(DuNode next){
		this.next = next;
	}
}
