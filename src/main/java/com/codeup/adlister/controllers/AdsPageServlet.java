package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdsPageServlet", value = "/showADS")
public class AdsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Ads adsDao = DaoFactory.getAdsDao();
		Ad adToUse = null;
		User adAuthor = null;

		adToUse = adsDao.findAdById(id);
		adAuthor = DaoFactory.getUsersDao().findUserById(adToUse.getId());

		request.setAttribute("adAuthor", adAuthor);
		request.setAttribute("ads", adToUse);
        request.setAttribute("users", DaoFactory.getUsersDao().allUsers());
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/adsPage.jsp").forward(request, response);
    }
}





