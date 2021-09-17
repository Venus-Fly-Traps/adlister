package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import javax.servlet.http.*;
import javax.servlet.annotation.*;



@WebServlet(name = "AdsPageServlet", value = "/ads")
public class AdsPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		Ad ad = (Ad) DaoFactory.getAdsDao().findById(id);
		request.setAttribute("ad", ad);

		long user_id = DaoFactory.getAdsDao().findUserId(id);
		User user = (User) DaoFactory.getAdsDao().findById(user_id);
		request.setAttribute("user", user);

		request.getRequestDispatcher("/WEB-INF/ads/display.jsp");

	}

}






