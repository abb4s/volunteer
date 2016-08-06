package domain;

import java.util.Date;

public class Acceptance {
	private Post post;
	private User volunteer;
	private Date date;
	private boolean verify=false;
	
	public Acceptance(Post post, User student) {
		super();
		this.post = post;
		this.volunteer = student;
		//this.date = date;
	}

	public void verify(){
		this.verify=true;
	}

	public Post getPost() {
		return post;
	}

	public User getStudent() {
		return volunteer;
	}

	public Date getDate() {
		return date;
	}

	public boolean isVerify() {
		return verify;
	}
	
	
}
