package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    Ad findById(long user_id);

    void updateAds(Ad ad);
    void deleteAds(long id);
    Ad findOneById(long id);
    List<Ad> getByUserId(long user_id);

    List<Ad> findAds(String keywords);


//    Object findAds(String keywords);
}
