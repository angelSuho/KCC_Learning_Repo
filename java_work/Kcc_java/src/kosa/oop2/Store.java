package kosa.oop2;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private String name;
	private String location;
	private List<Lunch> lunchList = new ArrayList<>();
	
	public Store() {}
	public Store(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public void registerLunch(Lunch lunch) {
		this.lunchList.add(lunch);
	}
	
	public void removeLunch(Lunch lunch) {
		if (this.lunchList.contains(lunch)) {
			this.lunchList.remove(lunch);
		}
	}
	
	public void findAll() {
		System.out.println("가게 이름: " + this.name);
		System.out.println("가게 위치: " + this.location);
		System.out.println();
	}
	
	public Lunch findByName(String name) throws Exception {
		for (Lunch lunch: lunchList) {
			if (lunch.getName().equals(name)) {
				return lunch;
			}
		}
		
		throw new Exception("없는 메뉴 입니다.");
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Lunch> getLunchList() {
		return this.lunchList;
	}
}
