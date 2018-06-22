package list;

public class Exam_ArrayList {
	public static void main(String[] args){
		nodes n = new nodes(5);
		for(int i = 0; i<n.o.length-1;i++){
			n.o[i] = i+1;
			
		}
		
		n.o[n.o.length-1] = 0;
		
	}
}
	
	class nodes{
		Object[] o ;
		int data;
		int pq, ph;
		nodes(int n){
			o = new Object[n];
			
		}
		public int getIndex(int i){
			
			return i;
			
		}
		
		public int getOData(int i){
			
			return (int) o[i];
			
		}
		
		public void setData(int data){
			this.data = data;
			
		}
		
		public int getData(){
			return data;
		}
	
}
