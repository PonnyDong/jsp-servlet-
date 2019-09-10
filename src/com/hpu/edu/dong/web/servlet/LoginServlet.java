package com.hpu.edu.dong.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpu.edu.dong.domain.User;
import com.hpu.edu.dong.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取数据
		HttpSession session = request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		/*if("tom".equals(username)&&"123".equals(password)){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}*/
		//传递给service层
		UserService service=new UserService();
		User user=null;
		try {
			user=service.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){
			//登录成功
			//将登录的用户的user对象存到session中
			String autoLogin=request.getParameter("autoLogin");
			if(autoLogin!=null){
				//编码
				String username_code = URLEncoder.encode(username, "UTF-8");
				String password_code = URLEncoder.encode(password, "UTF-8");
				Cookie cookie_username=new Cookie("cookie_username",username_code);
				Cookie cookie_password=new Cookie("cookie_password",password_code);
				cookie_username.setMaxAge(60);//自动登录持续时间
				cookie_password.setMaxAge(60);
				//设置访问路径
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				//发送cookie
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
				
			}
			
			session.setAttribute("user", user);//左边为名字，右边为值
			//登录成功后重定向到首页
			response.sendRedirect(request.getContextPath());
		}else{
			//登录失败
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}