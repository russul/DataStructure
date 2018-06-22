package list;

public class Exam1 {
	public static void main(String[] args){
		Sxlist L = new Sxlist(10);
		L.insert(0, 'W');
		L.insert(1, 'd');
		L.insert(2, '9');
		L.insert(3, 'd');
		L.insert(4, 'i');
		int order = L.indexOf('d');
		System.out.println("第一次出现d的位置是："+ order);
		L.display();
		L.remove(2);
		L.display();
		
	}

}
