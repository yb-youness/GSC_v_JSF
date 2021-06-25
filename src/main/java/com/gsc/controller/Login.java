package com.gsc.controller;

import javax.faces.bean.ManagedBean;

import com.gsc.dao.UserDao;
import com.gsc.dao.UserOps;
import com.gsc.model.User;

@ManagedBean
public class Login {

	private User user;
	
	
	public Login() {
		user=new User();
	}

	
	public String Check_user() {
		 UserOps opuser = new  UserDao();		 
			Boolean res = opuser.CheckUser(user);
			 if(res) {
				  // Add Sesion atrr
				 return "clients?faces-redirect=true";
			 }
                else {
                
                	
                	return "login?faces-redirect=true&error=true";
                }
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
