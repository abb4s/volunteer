package controller;

import java.util.ArrayList;

import app.PostRepository;
import app.DepartmentRepository;
import domain.Admin;
import domain.Acceptance;
import domain.Post;
import domain.Department;
import test.AdminUI;

public class AdminController {
	
	private AdminUI UI;
	private Admin admin;
	private Department department;
	/**
	 * @param args
	 */
	public AdminController() {
		UI=new AdminUI(this);
		
		try {
			admin=new Admin(1,"abbas","asdf",DepartmentRepository.getRepository().find("moavenat farhangi"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		department=admin.getDepartment();
		
	}
	public void createPost(String content,int capacity){
		admin.makePost(content, capacity);
	}
	public void viewPosts(){
		UI.setPosts(admin.getAllPost());
		// if the post is his own he can see users that who accept his post

	}
	public void viewSinglePost(int id){
		Post post=PostRepository.getRepository().findByID(id);
		ArrayList<Acceptance> acceptances=post.getAcceptancess();
		UI.setPost(post,acceptances);
		// if the post is his own he can see users that who accept his post
		 
	}
	

}
