package controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import domain.Acceptance;
import domain.Post;
import domain.Department;
import domain.User;
import app.AcceptanceRepository;
import app.PostRepository;
import app.DepartmentRepository;
import test.StudentUI;

public class StudentController {
	private StudentUI  UI;
	private User volunteer;
	/**
	 * @param args
	 */

	
	public StudentController(){
		UI=new StudentUI(this);
		listAllDepartments();
		volunteer=new User(1, "abbas", "abbas.hoseini74@gmial.com");
		
	}
	public void listAllDepartments(){
		ArrayList<Department> deps=DepartmentRepository.getRepository().findAll();
		UI.refreshDepartmentMenu(deps);
		
	}
	public void viewDepartmentPosts(String dpname){
		//Department dep=DepartmentRepository.getRepository().find(dpname);
		//ArrayList<Post> posts=dep.findAllPosts();
		ArrayList<Post> posts=PostRepository.getRepository().findDepartmetnPosts(dpname);
		//an alternative method for getDepartment Post that you should involve with AdminPostRepository
		//ArrayList<AdminPost> posts=AdminPostRepository.getRepository().findDepartmetnPosts(dep);
		UI.setPosts(posts);
		
		
	}
	public void viewSinglePost(int postId){
		Post post=PostRepository.getRepository().findByID(postId);
		UI.setSinglePost(post);
	
	}

	public void viewAcceptances(){
		ArrayList<Acceptance> acceptances=volunteer.getAllAcceptancess();
		UI.setAcceptances(acceptances);
	}
	public void accept(int postId){
		Post post=PostRepository.getRepository().findByID(postId);
		AcceptanceRepository.getRepository().add(new Acceptance(post, volunteer));
		viewAcceptances();
	}
	public void createPost(String content,int capacity){
		volunteer.makePost(content, capacity);
	}

}
