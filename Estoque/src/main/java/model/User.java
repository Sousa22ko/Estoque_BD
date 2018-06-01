package model;

public class User {
	
	private int id;
	private String user;
	private String senha;
	
	public User(int id, String user, String senha){
		this.id = id;
		this.user = user;
		this.senha = senha;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
