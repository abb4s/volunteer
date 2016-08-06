package controller;

import app.DepartmentRepository;
import domain.Department;

public class MainController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentRepository.getRepository().add(new Department("moavenat farhangi"));
		DepartmentRepository.getRepository().add(new Department("moavenat xyz"));
		
	
		Thread stT=new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new StudentController();
			}
		});
		Thread adT=new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new AdminController();
			}
		});
		stT.start();
		adT.start();


	}
	

}
