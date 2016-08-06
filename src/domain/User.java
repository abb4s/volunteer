package domain;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import app.AcceptanceRepository;
import app.PostRepository;



public class User {
	private int id;
	private String Name;
	private String email;
	private Department department=null;
	public User(int id, String name, String email) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void accept(Post post) {
		Acceptance accept=new Acceptance(post, this);
		AcceptanceRepository.getRepository().add(accept);
	}
	
	public void makePost(String content,int capacity)
	{
		Post post = new Post(content, this,this.department,capacity);
		PostRepository.getRepository().add(post);
	}

	public ArrayList<Acceptance> getAllAcceptancess(){
		return AcceptanceRepository.getRepository().
		getVolunteerAccepts(this.id);
	}
	public ArrayList<Post> getAllPost(){
		return PostRepository.getRepository().findByAuthor(this.id);
	}
	public ArrayList<Acceptance> getVerifyedAcceptances(){
		return null;
	}
	public void setDepartment(Department dp){
		this.department=dp;
	}
	public Department getDepartment(){
		return this.department;
	}
	
	
}
