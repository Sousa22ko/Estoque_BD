package dao;

import model.Loja;

public class UserDao extends GenericDao<Loja, Long> {

	public UserDao() {
		super(Loja.class);
	}
	
	public Loja getUserByUserName(String userName){		
		return (Loja)executeQuery("from User where userName = :userName").setParameter("userName", userName)
				.getSingleResult();
	}

	public void initialize() {
		// TODO Auto-generated method stub
	}
}
