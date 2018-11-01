package com.ph.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class Tool {
	
   // 输出内容到 response
   public static void writerToResponse(String content) throws IOException {
	 HttpServletResponse response  = ServletActionContext.getResponse();
	 response.setCharacterEncoding("UTF-8");
	 PrintWriter out = response.getWriter();
	 out.println(content);
	 out.flush();
	 out.close();
   }

}
