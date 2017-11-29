package model.bean;

public class ItemAgenda extends Agenda{
	private int idItemAgenda;
	private String title;
	private int startTime;
	private int endTime;
	public int getIdItemAgenda() {
		return idItemAgenda;
	}
	public void setIdItemAgenda(int idItemAgenda) {
		this.idItemAgenda = idItemAgenda;
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
	public ItemAgenda(int idAgenda, int day, int idSale, int idItemAgenda, String title, int startTime, int endTime) {
		super(idAgenda, day, idSale);
		this.idItemAgenda = idItemAgenda;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
