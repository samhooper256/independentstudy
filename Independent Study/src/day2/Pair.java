package day2;

public class Pair<T1, T2> {
	private T1 item1;
	private T2 item2;

	public Pair(T1 item1, T2 item2) {
		this.item1 = item1;
		this.item2 = item2;
	}
	
	public T1 getFirst() {
		return item1;
	}
	
	public T2 getSecond() {
		return item2;
	}
	
	public void setFirst(T1 item) {
		this.item1 = item;
	}
	
	public void setSecond(T2 item) {
		this.item2 = item;
	}
	
	public static <A, B, C, D> Pair<Pair<A, B>, Pair<C,D>> merge(Pair<A, B> pair1, Pair<C, D> pair2) {
		 return new Pair<>(pair1, pair2);
	}
	@Override
	public String toString() {
		return "Pair[" + item1 + ", " + item2 + "]";
	}

}
