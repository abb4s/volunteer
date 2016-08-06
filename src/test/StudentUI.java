package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.StudentController;


import domain.*;



public class StudentUI  extends JFrame{
	StudentController controller;
	Menu menu;
	MainPanel main=new MainPanel();
	public StudentUI(StudentController controller){
		
		super();
		this.controller=controller;
		menu=new Menu(this);
		
		add(menu );
		add(main);
		setSize(800, 600);
		this.setLayout(null);
		setVisible(true);
		repaint(); 
	}
	public void refreshDepartmentMenu(ArrayList<Department> departments){
		menu.completeMenu(departments);
		repaint();
	}
	public void setPosts(ArrayList<Post> posts){
		main.setPosts(posts);
		
	}
	public void setSinglePost(Post post){
		main.setSinglePost(post);
	}
	public void setAcceptances(ArrayList<Acceptance> acceptances){
		main.setAcceptanses(acceptances);
	}
	private class MainPanel extends JPanel{
		public MainPanel(){
			setLocation(200, 0);
			setSize(400,500);
			setLayout(null);
			setVisible(true);
		}
		public void setAcceptanses(ArrayList<Acceptance> acceptances){
			int y=0;
			JLabel content;
			JLabel department;
			JButton viewPost;
			removeAll();
			for(final Acceptance acceptance : acceptances){
				
				content=new JLabel(acceptance.getPost().getContent());
				department=new JLabel(acceptance.getPost().getDepartment().getName());
				viewPost=new JButton("view");
				viewPost.setSize(60, 60);
				viewPost.setLocation(270,y);
				
				content.setSize(200,60);
				content.setLocation(0,y);
				department.setSize(100,60);
				department.setLocation(210, y);
				add(content);
				add(department);
				//add(viewPost);
				
				viewPost.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						//controller.viewSinglePost(post.getId());
						
					}
				});
				
				y=y+60;
			}
			repaint();
		}
		
		public void setSinglePost(final Post post){
			removeAll();
			JLabel text=new JLabel();
			String str="<html><p>"+"id: "+post.getId()+"<br/>";
			str+=" content: "+post.getContent()+"<br/>";
			str+=" capacity: "+post.getCapacity()+"</p></html>";
			
			text.setText(str);
			add(text);
			JButton accept=new JButton("accept");
			accept.setSize(100,20);
			accept.setLocation(0,100);
			add(accept);
			accept.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					controller.accept(post.getId());
				}
			});
			repaint();
		}
		public void setPosts(ArrayList<Post> posts){
			int y=0;
			JLabel content;
			JLabel capacity;
			JButton viewPost;
			this.removeAll();
			for(final Post post : posts){
				content=new JLabel(post.getContent());
				capacity=new JLabel(post.getCapacity()+ "");
				viewPost=new JButton("view");
				viewPost.setSize(60, 60);
				viewPost.setLocation(270,y);
				
				content.setSize(200,60);
				content.setLocation(0,y);
				capacity.setSize(50,60);
				capacity.setLocation(210, y);
				add(content);
				add(capacity);
				add(viewPost);
				
				viewPost.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						controller.viewSinglePost(post.getId());
						
					}
				});
				
				y=y+60;
			}
			repaint();
		}
		
	}
	

	private class Menu extends JPanel{
		private  StudentUI frame;

		public void completeMenu(ArrayList<Department> departments){
			JButton depbtn;
			removeAll();
			int y=0;
			for(final Department dep:departments){
				depbtn=new JButton(dep.getName());
				depbtn.setSize(200, 20);
				depbtn.setLocation(0, y);
				depbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						controller.viewDepartmentPosts(dep.getName());
					}
				});
				add(depbtn);
				y=y+20;
				
			}
			depbtn=new JButton("view All my acceptances");
			depbtn.setSize(200, 20);
			depbtn.setLocation(0, y);
			depbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					controller.viewAcceptances();
				}
			});
			add(depbtn);
			
			repaint();
		}
		public Menu(StudentUI frame){
			
			this.frame=frame;
			
			
			setSize(200,500);
			setLayout(null);
			setVisible(true);
		}
		
	}
	
	


}

