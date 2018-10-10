package com.ph.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ph.model.UserModel;

public class LoginAction extends ActionSupport {
    public UserModel userModel;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		System.out.println("login success------------------------------------------");
	
		
		try {
//			System.out.println(userModel.getName());
//			System.out.println(userModel.getName() + "/今年" + userModel.getAge() + "岁" + "/n收入：" + userModel.getIncome());
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return SUCCESS;
	}

	public String login() {
		
		String result = "login info:";
		try {
			result = result + userModel.getName().toString();
			System.out.println(result);		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return SUCCESS;
	}
	
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
      
	
	
	
}
