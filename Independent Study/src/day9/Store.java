package day9;

import java.util.*;

public class Store {
	
	List<String> itemsForSale;
	
	public Store(List<String> items) {
		this.itemsForSale = new ArrayList<>(items);
	}
	
	public Store(String... items) {
		itemsForSale = new ArrayList<>(items.length);
		Collections.addAll(itemsForSale, items);
	}
	
	public List<String> getItems() {
		return Collections.unmodifiableList(itemsForSale);
	}
	
}