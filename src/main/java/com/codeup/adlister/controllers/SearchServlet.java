package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        try {
//            Ad ad = DaoFactory.getAdsDao().findById(getUserId(id));
//            request.setAttribute("ad", ad);
//            request.setAttribute("user", DaoFactory.getUsersDao().findById(ad.getUserId()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keywords = request.getParameter("search");
        request.setAttribute("keywords", keywords);
        request.setAttribute("foundAds", DaoFactory.getAdsDao().findAds(keywords));
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request,response);
    }
}
