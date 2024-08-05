package kosa.oop2.task;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	List<Store> stores = new ArrayList<>();
	
	public Manager() {}
	
	public void registerStore(Store store) {
		this.stores.add(store);
	}
	
	public Store searchStore(String name) throws Exception {
		for (Store store: stores) {
			if (store.getName().equals(name))
				return store;
		}
		
		throw new Exception("가게가 존재하지 않습니다.");
	}
	
	public List<Store> getStores() {
		return this.stores;
	}
}
