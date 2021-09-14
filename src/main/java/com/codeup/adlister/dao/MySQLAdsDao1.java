package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface MySQLAdsDao1 extends Ads {
    @Override
    List<Ad> all();

    List<Ad> usersAds(int id);

    @Override
    Long insert(Ad ad);
}
