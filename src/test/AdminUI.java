package test;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.AdminController;
import domain.*;

public class AdminUI extends JFrame {
	AdminController controller;
	CreatePanel createPanel;
	ListPanel listPanel;
	PostPanel postPanel;
	Menu menu;
	

	
	public AdminUI(AdminController controller){
		super("Admin app");
		this.controller=controller;
		setVisible(true);
		setSize(400, 600);
		this.setLayout(null);
		
		createPanel=new CreatePanel(this);
		listPanel =new ListPanel(this);
		postPanel=new PostPanel(this);
		menu=new Menu(this);
		add(menu);
		add(createPanel);
		add(listPanel);
		add(postPanel);
		createPanel.setVisible(false);
		
	}
	


	public void createPost(String content,int capacity){
		controller.createPost(content, capacity);
	}
	
	public void setPosts(ArrayList<Post> posts){
		
		listPanel.setPosts(posts);
	}
	public void setPost(Post post,ArrayList<Acceptance> accepts){
		postPanel.setPost(post,accepts);
	}

	public void viewCreatePanel(){
		listPanel.setVisible(false);
		createPanel.setVisible(true);
		postPanel.setVisible(false);
	}
	public void viewListPanel(){
		
		listPanel.setVisible(true);
		createPanel.setVisible(false);
		postPanel.setVisible(false);
		
	}
	public void viewPostPanel(){
		listPanel.setVisible(false);
		createPanel.setVisible(false);
		postPanel.setVisible(true);
	}
	
	
	
	
	
	private class CreatePanel extends JPanel{
		AdminUI frame;
		JButton submit =new JButton();
		JTextArea text=new JTextArea();
		JTextField capacity=new JTextField();
		
		public CreatePanel(AdminUI frame){
			this.frame=frame;
			System.out.print("ASDF");
			this.setLocation(100,50);
			this.setSize(400, 600);
			this.add(submit);
			this.add(text);
			this.add(capacity);
			this.setLayout(null);
			text.setSize(300, 200);
			
			capacity.setSize(100, 20);
			capacity.setLocation(0,210);
			
			submit.setSize(100, 20);
			submit.setLocation(0,240);
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					CreatePanel.this.frame.createPost(CreatePanel.this.text.getText().toString(),
							(int) Integer.parseInt(CreatePanel.this.capacity.getText()));
					controller.viewPosts();
					CreatePanel.this.frame.viewListPanel();
					
					
				}
			});

			
		}
		
	
	}
	private class ListPanel extends JPanel{
		AdminUI frame;
		private ArrayList<Post> posts;
		
		public ListPanel(AdminUI frame){
			this.frame=frame;
			this.setLocation(60,50);
			setLayout(null);
			this.setSize(500, 300);
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
						viewPostPanel();
					}
				});
				
				y=y+60;
			}
		}
	}
	private class PostPanel extends JPanel{
		AdminUI frame;
		private Post post;
		private JLabel text=new JLabel();;
		
		public PostPanel(AdminUI frame){
			this.setLocation(100,50);
			this.setSize(300, 300);
			text.setSize(300,200);
			add(text);
		}
		private void setPost(Post post,ArrayList<Acceptance> acceptances){
			
			String str="<html><p>"+"id: "+post.getId()+"<br/>";
			str+=" content: "+post.getContent()+"<br/>";
			str+=" capacity: "+post.getCapacity()+"<br/>";
			
			
			
			
			for(Acceptance acceptance:acceptances){
				str+="name :"+acceptance.getStudent().getName()+" "+"<br/>";
				
			}
			str+="</p></html>";
			
			text.setText(str);
		}
	}
	private class Menu extends JPanel{
		private  AdminUI frame;
		private JButton create=new JButton("create");
		private JButton list=new JButton("list");
		public Menu(AdminUI frame){
			this.frame=frame;
			setLocation(0,0);
			setSize(50,200);
			add(create);
			add(list);
			create.setSize(20, 50);
			list.setSize(0, 20);
			create.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					Menu.this.frame.viewCreatePanel();
				}
			});
			list.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					controller.viewPosts();
					Menu.this.frame.viewListPanel();
				}
			});
		}
		
	}

}
