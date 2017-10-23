package model.bean;

import java.util.ArrayList;
import java.util.List;

public class SchoolSchedule {
	private List classes = new ArrayList();

	public List getClasses() {
		return classes;
	}

	public void setClasses(List classes) {
		this.classes = classes;
	}

	public void addClass(SchoolClass schoolClass) {
		classes.add(schoolClass);
	}
}
