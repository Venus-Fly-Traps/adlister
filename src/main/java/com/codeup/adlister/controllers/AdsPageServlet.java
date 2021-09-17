package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "AdsPageServlet", value = "/ad")
public class AdsPageServlet extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		long id = Long.parseLong(request.getParameter("id"));
//		Ad ad = DaoFactory.getAdsDao().findById(id);
//		request.setAttribute("ad", ad);
//
//		long user_id = DaoFactory.getAdsDao().findUserId(id);
//		User user = DaoFactory.getUsersDao().findById(user_id);
//		request.setAttribute("user", user);
//
//		request.getRequestDispatcher("WEB-INF/ads/display.jsp").forward(request, response);
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/login");
			return;
		}
		User user = (User) request.getSession().getAttribute("user");
		try {
			request.setAttribute("ad", DaoFactory.getAdsDao().findById(user.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/ads/display.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}






