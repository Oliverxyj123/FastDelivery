package com.tboys.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.tboys.dao.impl.DoRegisterDaoImpl;
import com.tboys.listner.AppListner;
import com.tboys.model.User;

/**
 * Servlet implementation class DoRegisterServlet
 */
public class DoRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		doGet(request, response);//ÉèÖÃ×Ö·û¼¯
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute(AppListner.DATE_SOURCE);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DoRegisterDaoImpl drdi = new DoRegisterDaoImpl(conn);
		boolean isSucced = drdi.judgeRegisterUser(new User(account, pwd));
		if(isSucced){
			
		}else{
			
		}
	}

}
