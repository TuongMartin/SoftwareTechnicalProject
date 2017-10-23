package model.bean;

public class SchoolClass {
	private int scheduleID;
	private String title;
	private int startTime;
	private int endTime;
	private int day;
	private int IdNhanVien;
	public int getScheduleID() {
		return scheduleID;
	}
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getIdNhanVien() {
		return IdNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		IdNhanVien = idNhanVien;
	}
	public SchoolClass(int scheduleID, String title, int startTime, int endTime, int day, int idNhanVien) {
		this.scheduleID = scheduleID;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
		IdNhanVien = idNhanVien;
	}
	
}
