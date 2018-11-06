package com.ph.action;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;




public class TestAction  implements InitializingBean{

	@Autowired
	private Test1Action test1Action;
	private Test1Action getTest1Action() {
		return test1Action;
	}
	
	
	
	
    private String name;
	public void printName() {
		getTest1Action().print();		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public void afterPropertiesSet() throws Exception {
    	// TODO Auto-generated method stub
    	System.out.println("afterPropertiesSet");
    }
	public void init() {
		System.out.println("init");
	}
	public void destroy() {
		System.out.println("destroy");
	}
	
	@RequestMapping("test/hello")
	public String tes() {
		return "{‘code’:‘100’,‘Message’:‘成功’}";
	}
}
