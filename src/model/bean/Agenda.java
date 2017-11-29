package model.bean;

public class Agenda {
	private int idAgenda;
	private int day;
	private int idSale;
	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getIdSale() {
		return idSale;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public Agenda(int idAgenda, int day, int idSale) {
		this.idAgenda = idAgenda;
		this.day = day;
		this.idSale = idSale;
	}
	
	
}
