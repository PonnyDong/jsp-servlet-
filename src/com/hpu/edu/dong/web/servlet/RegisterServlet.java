package com.hpu.edu.dong.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.hpu.edu.dong.domain.User;
import com.hpu.edu.dong.service.UserService;

import com.mchange.v2.beans.BeansUtils;


public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获得表单数据
		Map<String, String[]> properties = request.getParameterMap();//封装对象
		User user=new User();
		try {
			//自己指定一个类型转换器
			ConvertUtils.register(new Converter() {
				@Override
				public Object convert(Class clazz, Object value) {
					// TODO Auto-generated method stub
					//将String转为date
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date parse=null;
					try {
						parse = (Date) format.parse(value.toString());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return parse;
				}
			}, Date.class);
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将user传递给service层
		UserService service=new UserService();
		boolean isRegisterSuccess=service.register(user);
		//是否注册成功
		if(isRegisterSuccess){
			//成功
			response.sendRedirect(request.getContextPath()+"/registerSuccess.jsp");
		}else{
			//失败
			response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}