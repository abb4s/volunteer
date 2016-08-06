package domain;


import java.util.ArrayList;

import app.PostRepository;

public class Department {
	private String name;
	



	public Department(String name){
		this.name=name;
		
	}
	public ArrayList<Post> findAllPosts(){
		return PostRepository.getRepository().findDepartmetnPosts(this.getName());
	} 
	
	public String getName(){
		return name;
	}
}
