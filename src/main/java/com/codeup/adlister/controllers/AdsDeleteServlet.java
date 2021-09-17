package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdsDeleteServlet", urlPatterns = "/ads/deletead")
public class AdsDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("/login");
                return;
            }
            String adId = request.getParameter("ad_id");
//        Ads ads = DaoFactory.getAdsDao();
//
            request.setAttribute("id", adId);
            request.getRequestDispatcher("/WEB-INF/ads/deletead.jsp")
                    .forward(request, response);
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        long id = Long.parseLong(request.getParameter("id"));
        // validate input

        DaoFactory.getAdsDao().deleteAds(id);
        response.sendRedirect("/profile");
    }

}

