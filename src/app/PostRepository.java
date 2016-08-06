package app;

import java.util.ArrayList;

import domain.Post;
import domain.Department;


public class PostRepository {

	private static PostRepository repository=null;
	private ArrayList<Post> posts=new ArrayList<>();
	
	private PostRepository(){
		posts=new ArrayList<>();
	}
	public static PostRepository getRepository(){
		if(repository==null)
		{
			repository=new PostRepository();
		}
		return repository;
	}
	public void add(Post post){
		posts.add(post);
	}
	public Post findByID(int id){
		for(Post post:posts){
			if(post.getId()==id){
				return post;
			}
		}
		return null;
	}
	public ArrayList<Post> findDepartmetnPosts(String dpname){
		ArrayList<Post> res=new ArrayList<>();
		for(Post post: posts){
			if(post.getDepartment().getName().equals(dpname) ){
				res.add(post);
			}
		}
		return res;
	}
	public ArrayList<Post> findByAuthor(int id){
		ArrayList<Post> res=new ArrayList<>();
		for(Post post: posts){
			if(post.getAuthor().getId()== id){
				res.add(post);
			}
		}
		return res;
	}
	public void edit(){
		
	}
	public void delete(){
		
	}
}
