package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    public List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad) {
        if (ads == null) {
            ads = generateAds();
        }
        ad.setId(ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public Ad findAdById(int id) {
        return null;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            1,
            "PS5 Cheap!",
            "Basically brand-new! Only used for 1 month of continuous gaming."
        ));
        ads.add(new Ad(
            2,
            1,
            "XBox 1",
            "Not a bad little system!"
        ));
        ads.add(new Ad(
            3,
            2,
            "JAVA DUDE needed now!!!",
            "Minimum 3 years of experience required. You will be working in the scripting                       language for Java, JavaScript. Recent graduate of CODEUP ACADEMY a PLUS!"
        ));
        ads.add(new Ad(
            4,
            2,
            "WEB Developer for thriving young company...grow with us!@",
            "Must have strong WEB Dev skills"
        ));
        return ads;
    }
}
