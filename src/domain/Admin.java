package domain;

import java.util.ArrayList;

import app.PostRepository;




public class Admin extends User{
	
	



	public Admin(int id, String name, String email, Department department) throws Exception {
		super(id, name, email);
		if(department==null){
			throw new Exception("department name can not be null");
		}
		this.setDepartment(department);
	}





	public void verify(Acceptance accept){
		accept.verify();
	}

	

}
