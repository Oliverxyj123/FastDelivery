package com.tboys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.tboys.dao.impl.DoLoginDaoImpl;
import com.tboys.dao.impl.DoRegisterDaoImpl;
import com.tboys.listner.AppListner;
import com.tboys.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	

	public static final String USER = "user";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute(AppListner.DATE_SOURCE);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DoLoginDaoImpl dldi = new DoLoginDaoImpl(conn);
		User user = new User(account, pwd);
		boolean isSucced = dldi.judgeLoginUser(user);
		if(isSucced){
			session.setAttribute(USER, user);
		}else{
			
		}
	}

}
