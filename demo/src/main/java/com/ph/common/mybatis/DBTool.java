package com.ph.common.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBTool {
    public static  SqlSessionFactory sqlSessionFactory;
	static{
		try {
			//使用MyBatis 提供的Resources
			Reader reader = Resources.getResourceAsReader("config/mybatis/mybatis-config.xml");
			
			// 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	// 创建能执行 映射文件的sql session
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	
}
