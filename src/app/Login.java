package app;

import domain.User;


public class Login {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public User volunteerLogIn(String username,String password){
		
		return null;
	}
	public User adminLogin(String username,String password,String department){
		return null;
	}
	
	public User register(int id,String username,String password,String email){
		return new User(id, username, email);
	}

}
