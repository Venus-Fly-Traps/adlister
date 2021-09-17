package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "controllers.AdsUpdateServlet", urlPatterns = "/ads/update")
public class AdsUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
    String adId = request.getParameter("ad_id");
        Ad ad = DaoFactory.getAdsDao().findOneById(Long.parseLong(adId));
//
        request.setAttribute("adtoUpdate", ad);
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");


        // validate input
        boolean inputHasErrors =
                title.isEmpty()
                || description.isEmpty();


        if (inputHasErrors) {
            
            response.sendRedirect("/ads/update");
            return;
        }

        // create and save a new user

        Ad ad = new Ad();
        ad.setId(id);
        ad.setTitle(title);
        ad.setDescription(description);
        DaoFactory.getAdsDao().updateAds(ad);
        response.sendRedirect("/ads");
    }
    }

