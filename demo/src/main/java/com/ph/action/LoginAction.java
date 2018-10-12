package com.ph.action;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.ActionSupport;
import com.ph.common.mybatis.DBTool;
import com.ph.mapper.UserMapper;
import com.ph.model.UserModel;

public class LoginAction extends ActionSupport {
    private static final long serialVersionUID = 2L;
    public UserModel userModel;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub		
		System.out.println("login success------------------------------------------");
	
		
		try {
//			System.out.println(userModel.getName());
//			System.out.println(userModel.getName() + "/����" + userModel.getAge() + "��" + "/n���룺" + userModel.getIncome());
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return SUCCESS;
	}

	public String login() throws IOException {
//		String resource = "/config/mybatis/mybatis-config.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
//		System.out.println(sqlSessionFactory);
		
		 SqlSession session=DBTool.getSession();
		 
	     UserMapper mapper=session.getMapper(UserMapper.class);
	     try {
		    List<UserModel> user=mapper.selectAllUser();
		    System.out.println(user.toString());
		    session.commit();
		 } catch (Exception e) {
		    e.printStackTrace();
		    session.rollback();
         }
		
		
		
		
		
		String result = "login info:";
		try {
			result = result + userModel.getUsername().toString();
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
