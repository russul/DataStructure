package list;

public class Node {
	public Object data;
	public Node next;
	//无参的构造方法可以初始化一个空的节点
	public Node(){       
		this(null,null);
	}
	
	public Node(Object data){
		this(data,null);
	}
	
	public Node(Object data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public Object getData(){
		return data;
	}
	
	public void setData(Object data){
		this.data = data;
	} 
	
	public Node getNext(){
		return next;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
}
