package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;


@WebServlet(name = "AdsPageServlet", value = "/ad")
public class AdsPageServlet extends HttpServlet {
	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 	 ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/login");
			return;
		}
		long id = Long.parseLong(request.getParameter("ad_id"));
		try {
			Ad ad = DaoFactory.getAdsDao().findById(id);
			request.setAttribute("ad", ad);
			request.setAttribute("user", DaoFactory.getUsersDao().findById(ad.getUserId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/ads/display.jsp").forward(request, response);
	}

}









