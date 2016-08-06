
package app;

import java.util.ArrayList;

import domain.User;

public class UserRepository {

	private static UserRepository repository=null;
	private ArrayList<User> users;
	
	private UserRepository(){
		users=new ArrayList<>();
	}
	public static UserRepository getRepository(){
		if(repository==null)
		{
			repository=new UserRepository();
		}
		return repository;
	}
	public void add(User user){
		users.add(user);
	}
	public User findById(int id){
		return null;
	}
	
}
