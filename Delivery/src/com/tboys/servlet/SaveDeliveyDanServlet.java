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

import com.tboys.dao.impl.DeliveryDanManageDaoImpl;
import com.tboys.listner.AppListner;
import com.tboys.model.DeliveryDan;
import com.tboys.model.User;

/**
 * 保存快递记录
 * @author Dell
 *
 */
public class SaveDeliveyDanServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext application = getServletContext();
		DataSource ds = (DataSource) application.getAttribute(AppListner.DATE_SOURCE);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(LoginServlet.USER);
		
		DeliveryDanManageDaoImpl ddmd = new DeliveryDanManageDaoImpl(conn);
		
//		String;;;;;;;
		DeliveryDan dan = new DeliveryDan();
		if (user != null) {
			
			//从客户端获取的(除时间, 快递内容)
			ddmd.insertDelivery(dan);
			
		}else{
			
		}
	}
}
