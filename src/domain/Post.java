package domain;

import java.sql.Date;
import java.util.ArrayList;

import app.AcceptanceRepository;

public class Post {
	private static int Lastid=0;
	private int id;
	private Date date;
	private String content;
	private User author;
	private int capacity;
	private Department department;

	
	public Department getDepartment() {
		return department;
	}
	public Post(String content, User author, Department department,int capacity) {
		id=Lastid++;
		this.content = content;
		this.author = author;
		this.department = department;
		this.capacity=capacity;
		//set Date later
	}
	public ArrayList<Acceptance> getAcceptancess(){
		return AcceptanceRepository.getRepository().getPostAccepts(this);
		
	}
	
	public String getContent(){
		return content;
	}
	public int getCapacity(){
		return capacity;
	}
	public int getId(){
		return id;
	}
	public User getAuthor(){
		return this.author;
	}

}
