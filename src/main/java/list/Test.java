package list;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuLinkedListNoHead T = new DuLinkedListNoHead(500);
		DuNode p = T.first;
		int count = 0;
		while(count!=T.length()){
			p.setData(count);
			p = p.getNext();
			count ++;
		}
//		T.display();
		
		while(T.length()!=1){
			for(int i = 0;i<3;i++){
				p = p.getNext();

			}
			T.remove(p.getPrior());
		}
		T.display();
	}
}
