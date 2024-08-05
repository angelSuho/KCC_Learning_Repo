package kosa.relation;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Course> courses;	// 학생이 수강신청한 과목
	
	public Student() {}
	public Student(String name) {
		this.name = name;
		courses = new ArrayList<Course>();
	}
	
	public void register(Course course) {
		courses.add(course);
		course.addStudent(this);
	}
	
	public void dropCourse(Course course) {
		if (courses.contains(course)) {
			courses.remove(course);
		}
		course.removeStudent(this);
	}
	
	public void printMember() {
		System.out.println("학생 이름: " + name);
		for (Course course: courses) {
			System.out.println("수강 과목: " + course.getName());
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
