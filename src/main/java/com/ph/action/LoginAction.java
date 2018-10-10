package com.ph.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		System.out.println("login success------------------------------------------");
		return SUCCESS;
	}
      
}
