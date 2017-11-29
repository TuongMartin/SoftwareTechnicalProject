package model.bean;

public class Role {
	private int idrole;
	private String role;

	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Role(int idrole,String role) {
		this.idrole = idrole;
		this.role = role;
	}
}
