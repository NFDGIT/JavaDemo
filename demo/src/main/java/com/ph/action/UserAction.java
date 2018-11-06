package com.ph.action;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ph.common.Tool;
import com.ph.common.mybatis.DBTool;
import com.ph.mapper.UserMapper;
import com.ph.model.UserModel;
import com.ph.model.UserModelAPI;



public class UserAction extends ActionSupport {
	public UserModelAPI userModel;	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 登录
	public String login() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/config/spring/Beans.xml");
		TestAction testAction = (TestAction) context.getBean("testAction");
		testAction.printName();
        
    	return SUCCESS;
	} 
	
	// 注册
    public String regist() {
		SqlSession session = DBTool.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
	
		
	    try {
	    	
	    	
	    	UserModel userMd = new UserModel();
	    	if (userModel == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "保存失败,实体类不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
	    		
	    		
	    		return ERROR;
			}
	    	
	    	
	    	if (userModel.getId() == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "保存失败,id 不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
	    		
	    		
	    		return ERROR;
			}
	    	if (userModel.getUsername() == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "保存失败,名字不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
			    
	    		return ERROR;
			}
	    	if (userModel.getPassword() == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "保存失败,密码不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
			    
	    		return ERROR;
			}
	    	
	    	
	        userMd.setId(userModel.getId());
	        userMd.setUsername(userModel.getUsername());
	        userMd.setPassword(userModel.getPassword());
	   
		    mapper.insertUser(userMd);
		    
		    
		    JSONObject jsonObject = new JSONObject();
		    jsonObject.put("code", "200");
		    jsonObject.put("message", "保存成功");
		    Tool.writerToResponse(jsonObject.toString());
	
		    session.commit();
		 } catch (Exception e) {
			    e.printStackTrace();
			    session.rollback();
	     }
    	return SUCCESS;
	}
    
    // 查询全部用户
    public String selectAllUser() {
		 SqlSession session=DBTool.getSession();
	     UserMapper mapper=session.getMapper(UserMapper.class);

	     try {
		    UserModel userMd = new UserModel();
		    userMd.setId(userModel.getId());
	    	 
	    	 
		    List<UserModel> user=mapper.selectAllUser(userMd);
		    JSONArray jsonArray = new JSONArray(user);
			session.commit();
		    
		    
		    Tool.writerToResponse(jsonArray.toString());
		 } catch (Exception e) {
		    e.printStackTrace();
		    session.rollback();
         }
		return SUCCESS;
	}
    // 更新信息
    public String updateUser() {
		SqlSession session = DBTool.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

	    try {
	    	
	    	UserModel userMd = new UserModel();
	    	if (userModel == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "保存失败,实体类不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
	    		
	    		
	    		return ERROR;
			}
	    	
	    	
	    	if (userModel.getId() == null) {
			    JSONObject jsonObject = new JSONObject();
			    jsonObject.put("code", "201");
			    jsonObject.put("message", "修改失败,id 不能为空！");
			    Tool.writerToResponse(jsonObject.toString());
	    
	    		return ERROR;
			}
	         
	        userMd.setId(userModel.getId());
	        userMd.setUsername(userModel.getUsername());
	        userMd.setPassword(userModel.getPassword());
	   
		    mapper.updateUser(userMd);;
		    
		    
		    JSONObject jsonObject = new JSONObject();
		    jsonObject.put("code", "200");
		    jsonObject.put("message", "修改成功");
		    Tool.writerToResponse(jsonObject.toString());
	
		    session.commit();
		 } catch (Exception e) {
			    e.printStackTrace();
			    session.rollback();
	     }
    	return SUCCESS;
	}

    
    
    
    
    // 所有的  set get 方法
	public UserModelAPI getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModelAPI userModel) {
		this.userModel = userModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
