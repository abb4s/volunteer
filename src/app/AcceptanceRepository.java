package app;
import java.util.ArrayList;

import domain.Acceptance;
import domain.Post;
import domain.User;


public class AcceptanceRepository {
	private static AcceptanceRepository repository=null;
	private ArrayList<Acceptance> acceptances;
	
	private AcceptanceRepository(){
		acceptances=new ArrayList<>();
	}
	public static AcceptanceRepository getRepository(){
		if(repository==null)
		{
			repository=new AcceptanceRepository();
		}
		return repository;
	}
	public void add(Acceptance accept){
		acceptances.add(accept);
	}
	public ArrayList<Acceptance> getVolunteerAccepts(int id){
		ArrayList<Acceptance> accepts=new ArrayList<>();
		for(Acceptance acc: acceptances){
			if(acc.getStudent().getId()==id){
				accepts.add(acc);
			}
		}
		return accepts;
	}
	public ArrayList<Acceptance> getPostAccepts(Post post){
		ArrayList<Acceptance> accepts=new ArrayList<>();
		for(Acceptance acc: acceptances){
			if(acc.getPost()==post){
				accepts.add(acc);
			}
		}
		return accepts;
	}
}
