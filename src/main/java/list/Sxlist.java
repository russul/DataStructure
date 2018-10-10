package list;

public class Sxlist implements IList {
	@Override
	public void remove(DuNode s) {
		// TODO Auto-generated method stub
		
	}


	private Object[] listElem;
	private int curlen;
	
	public Sxlist(int maxSize){
		curlen = 0;
		listElem = new Object[maxSize];
	}

	@Override
	public void clear() {
		curlen = 0;
		
	}

	@Override
	public boolean isEmpty() {
		
		return curlen == 0;
	}

	@Override
	public int length() {
		
		return curlen;
	}

	@Override
	public Object get(int i) {
		if(i<0||i>curlen-1){
			System.out.println("第"+i+"个元素不存在");
			
		}
		return listElem[i];
		
	}

	@Override
	public void insert(int i, Object x) {
		if(curlen == listElem.length){
			System.out.println("顺序表已满");
		}
		if(i <0||i>curlen){
			System.out.println("插入不合法");
			
		}
		for(int j = i; j<curlen;j++){
			listElem[j+1] = listElem[j];
		}
		listElem[i] = x;
		curlen++;
		
	}

	@Override
	public void remove(int i) {
		if(curlen == 0){
			System.out.println("顺序表已空");
		}
		if(i <0||i>curlen-1){
			System.out.println("删除不合法");
			
		}
		for(int j = i;j<curlen-1;j++){
			listElem[j] = listElem[j+1];
		}
		curlen--;
	}

	@Override
	public int indexOf(Object x) {
		int j = 0;
		while(j<curlen && !listElem[j].equals(x)){
			j++;
		}
		
			if(j<curlen){
				return j;
			}else{
				return -1;
			}
			
	}


	@Override
	public void display() {
		for(int j = 0;j<curlen;j++){
			System.out.print(listElem[j]+ "  ");
		}
		System.out.println();
	}

}
