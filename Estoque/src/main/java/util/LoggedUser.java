package util;

import model.Loja;

public class LoggedUser {
	
	private static Loja log = new Loja();
	
	public static void setUserLogged(Loja logado){
		
		log = logado;
	}
	
	public static Loja getLoggedUser(){
		return log;
	}

}
